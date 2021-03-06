package com.jez.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LoLProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;

	private String username;

	private String league;

	private String division;

	private String faveChamp;

	private String favePosition;
	
	private String tag;
	
	private String notes;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getFaveChamp() {
		return faveChamp;
	}

	public void setFaveChamp(String faveChamp) {
		this.faveChamp = faveChamp;
	}

	public String getFavePosition() {
		return favePosition;
	}

	public void setFavePosition(String favePosition) {
		this.favePosition = favePosition;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
