package com.jez.persistence.repository;

import javax.transaction.Transactional;

import com.jez.persistence.domain.Team;
import com.jez.persistence.domain.User;
import com.jez.util.JSONUtil;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Transactional(SUPPORTS)
@Default
public class TeamH2DBRepository implements TeamRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil jsonUtil;

	private String successMessage = "{\"message\":\"Success\"}";
	private String failureMessage = "{\"message\":\"Failure\"}";

	@Transactional(REQUIRED)
	public String createTeam(String team) {
		Team myTeam = jsonUtil.getObjectForJSON(team, Team.class);
		manager.merge(myTeam);
		return this.successMessage;
	}

	public String getAllTeams() {
		TypedQuery<Team> query = manager.createQuery("SELECT t from Team t", Team.class);
		return jsonUtil.getJSONForObject(query.getResultList());
	}

	public String getTeamById(long id) {
		return jsonUtil.getJSONForObject(manager.find(Team.class, id));
	}

	@Transactional(REQUIRED)
	public String updateTeam(long id, String team) {
		Team myTeam = jsonUtil.getObjectForJSON(team, Team.class);
		manager.detach(manager.find(Team.class, id));
		Team tempTeam = manager.merge(myTeam);
		manager.flush();
		if (jsonUtil.getJSONForObject(tempTeam).equals(team)) {
			return this.successMessage;
		} else {
			return this.failureMessage;
		}
	}

	@Transactional(REQUIRED)
	public String deleteUser(long id) {
		Team myTeam = manager.find(Team.class, id);
		if (myTeam != null) {
			manager.remove(myTeam);
			return this.successMessage;
		} else {
			return this.failureMessage;
		}
	}

}
