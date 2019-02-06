package com.jez.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.jez.business.UserBusiness;

@Path("/user")
public class UserEndpoints {
	
	@Inject
	private UserBusiness service;
	
	@Path("/")
	@GET
	public String getAllUsers() {
		return service.getAllUsers();
	}
	
	@Path("/{id}")
	@GET
	public String getUserById(@PathParam("id")long id) {
		return service.getUserById(id);
	}
	
	@Path("/")
	@POST
	public String createUser(String user) {
		return service.createUser(user);
	}
	
	@Path("/{id}")
	@PUT
	public String updateUser(@PathParam("id") long id, String user) {
		return service.updateUser(id, user);
	}
	
	@Path("/{id}")
	@DELETE
	public String deleteUser(@PathParam("id") long id) {
		return service.deleteUser(id);
	}
}
