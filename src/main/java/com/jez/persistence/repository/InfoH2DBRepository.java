package com.jez.persistence.repository;

import javax.transaction.Transactional;

import com.jez.util.JSONUtil;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Transactional(SUPPORTS)
@Default
public class InfoH2DBRepository implements InfoRepository{

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil jsonUtil;

	private String successMessage = "{\"message\":\"Success\"}";
	private String failureMessage = "{\"message\":\"Failure\"}";
	
	public String getAllLeagueChamps() {
		Query query = manager.createQuery("Select c from Leaguechampenum c");
		return jsonUtil.getJSONForObject(query.getResultList());
	}

	public String getAllDotaHeroes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
