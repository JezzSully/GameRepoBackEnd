package com.jez.persistence.repository;

public interface UserRepository {

	public String createUser(String user);
	
	public String getAllUsers();
	
	public String getUserById(long id);
	
	public String updateUser(long id, String user);
	
	public String deleteUser(long id);
}
