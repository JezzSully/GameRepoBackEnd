package com.jez.gameRepoBackEnd;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.After;

import com.jez.persistence.domain.User;
import com.jez.persistence.repository.UserH2DBRepository;
import com.jez.util.JSONUtil;

@Ignore
public class UserRepoTest {

	private UserH2DBRepository myRepo;
	
	private JSONUtil jsonUtil;
	
	private User exampleUser1;
	private User exampleUser2;
	
	private String successMessage = "{\"message\":\"Sucess\"}";
	private String failureMessage = "{\"message\":\"Failure\"}";
	
	@Before
	public void setUp() {
		myRepo = new UserH2DBRepository();
		jsonUtil = new JSONUtil();
		exampleUser1 = new User(1L, "JezzSully", 23, "J@J.com", null, null, "");
		exampleUser2 = new User(2L, "TestName", 55, "F@F.com", null, null, "");
	}

	@After
	public void tearDown() {
		
	}
	
	@Test
	public void addUserTest() {
		String userJson = jsonUtil.getJSONForObject(exampleUser1);
		assertTrue(this.successMessage.equals(myRepo.createUser(userJson)));
		User[] users = jsonUtil.getObjectForJSON(myRepo.getAllUsers(), User[].class);
		assertEquals(1, users.length);
	}
	
	@Test
	public void getSingleUserTest() {
		String userJson = jsonUtil.getJSONForObject(exampleUser1);
		myRepo.createUser(userJson);
		assertEquals(myRepo.getUserById(exampleUser1.getId()),exampleUser1);
	}
	
	@Test
	public void updateUserTest() {
		String userJson = jsonUtil.getJSONForObject(exampleUser1);
		myRepo.createUser(userJson);
		exampleUser1.setAge(45);
		userJson = jsonUtil.getJSONForObject(exampleUser1);
		myRepo.updateUser(exampleUser1.getId(), userJson);
	}
	
	@Test
	public void removeUserTest() {
		myRepo.createUser(jsonUtil.getJSONForObject(exampleUser1));
		assertTrue(this.successMessage.equals(myRepo.deleteUser(exampleUser1.getId())));
		User[] users = jsonUtil.getObjectForJSON(myRepo.getAllUsers(), User[].class);
		assertEquals(0, users.length);
	}
	
	@Test
	public void removeUserFailTest() {
		myRepo.createUser(jsonUtil.getJSONForObject(exampleUser1));
		assertTrue(this.failureMessage.equals(myRepo.deleteUser(exampleUser2.getId())));
	}
}
