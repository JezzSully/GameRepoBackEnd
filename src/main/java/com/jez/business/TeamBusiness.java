package com.jez.business;

import javax.inject.Inject;

import com.jez.persistence.repository.TeamRepository;

public class TeamBusiness {

	@Inject
	private TeamRepository myRepo;

	public String createTeam(String team) {
		return myRepo.createTeam(team);
	}

	public String getAllTeams() {
		return myRepo.getAllTeams();
	}

	public String getTeamById(long id) {
		return myRepo.getTeamById(id);
	}

	public String updateTeam(long id, String team) {
		return myRepo.updateTeam(id, team);
	}

	public String deleteUser(long id) {
		return myRepo.deleteUser(id);
	}
}
