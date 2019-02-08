package com.jez.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.jez.business.TeamBusiness;

@Path("/team")
public class TeamEndpoints {

	@Inject
	private TeamBusiness service;

	@Path("/")
	@GET
	public String getAllTeams() {
		return service.getAllTeams();
	}

	@Path("/{id}")
	@GET
	public String getTeamById(@PathParam("id") long id) {
		return service.getTeamById(id);
	}

	@Path("/")
	@POST
	public String createTeam(String team) {
		return service.createTeam(team);
	}

	@Path("/{id}")
	@PUT
	public String updateTeam(@PathParam("id") long id, String team) {
		return service.updateTeam(id, team);
	}

	@Path("/{id}")
	@DELETE
	public String deleteTeam(@PathParam("id") long id) {
		return service.deleteUser(id);
	}
}
