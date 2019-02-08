package com.jez.persistence.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.jez.persistence.domain.User;
import com.jez.util.JSONUtil;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@Transactional(SUPPORTS)
@Default
public class UserH2DBRepository implements UserRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil jsonUtil;

	private String successMessage = "{\"message\":\"Success\"}";
	private String failureMessage = "{\"message\":\"Failure\"}";

	@Transactional(REQUIRED)
	public String createUser(String user) {
		User myUser = jsonUtil.getObjectForJSON(user, User.class);
		manager.persist(myUser);
		return this.successMessage;
	}

	public String getAllUsers() {
		TypedQuery<User> query = manager.createQuery("SELECT u from User u", User.class);
		return jsonUtil.getJSONForObject(query.getResultList());
	}

	public String getUserById(long id) {
		return jsonUtil.getJSONForObject(manager.find(User.class, id));
	}

	@Transactional(REQUIRED)
	public String updateUser(long id, String user) {
		User myUser = jsonUtil.getObjectForJSON(user, User.class);
		manager.detach(manager.find(User.class, id));
		User tempUser = manager.merge(myUser);
		manager.flush();
		if(jsonUtil.getJSONForObject(tempUser).equals(user)) {
			return this.successMessage;
		} else {
			return this.failureMessage;
		}
	}

	@Transactional(REQUIRED)
	public String deleteUser(long id) {
		User myUser = manager.find(User.class, id);
		if (myUser != null) {
			manager.remove(myUser);
			return this.successMessage;
		} else {
			return this.failureMessage;
		}
	}
}
