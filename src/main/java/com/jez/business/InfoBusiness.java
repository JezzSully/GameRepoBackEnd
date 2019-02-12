package com.jez.business;

import javax.inject.Inject;

import com.jez.persistence.repository.InfoRepository;

public class InfoBusiness {

	@Inject
	private InfoRepository myRepo;
	
	public String getAllLegueChamps() {
		return myRepo.getAllLeagueChamps();
	}
}
