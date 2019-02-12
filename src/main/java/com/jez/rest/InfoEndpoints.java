package com.jez.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.jez.business.InfoBusiness;

@Path("/info")
public class InfoEndpoints {
	
	@Inject
	private InfoBusiness service;
	
	@Path("/leagueChamps")
	@GET
	public String getAllLeagueChamps() {
		return service.getAllLegueChamps();
	}
}
