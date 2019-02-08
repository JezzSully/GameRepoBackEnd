package com.jez.persistence.repository;

public interface TeamRepository {

	public String createTeam(String team);

	public String getAllTeams();

	public String getTeamById(long id);

	public String updateTeam(long id, String team);

	public String deleteUser(long id);
}
