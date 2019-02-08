package com.jez.business;

import javax.inject.Inject;

import com.jez.persistence.repository.UserRepository;

public class UserBusiness {

	@Inject
	private UserRepository myRepo;

	public String getAllUsers() {
		return myRepo.getAllUsers();
	}

	public String getUserById(long id) {
		return myRepo.getUserById(id);
	}

	public String createUser(String user) {
		return myRepo.createUser(user);
	}

	public String updateUser(long id, String user) {
		return myRepo.updateUser(id, user);
	}

	public String deleteUser(long id) {
		return myRepo.deleteUser(id);
	}
}
