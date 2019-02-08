package com.jez.persistence.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;

	private String username;

	private int age;

	private String email;

	@OneToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private LoLProfile leagueProfile;

	private String passHash;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LoLProfile getLeagueProfile() {
		return leagueProfile;
	}

	public void setLeagueProfile(LoLProfile leagueProfile) {
		this.leagueProfile = leagueProfile;
	}

	public String getPassHash() {
		return passHash;
	}

	public void setPassHash(String passHash) {
		this.passHash = passHash;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}
}
