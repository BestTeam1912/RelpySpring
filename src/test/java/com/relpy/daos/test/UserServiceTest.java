package com.relpy.daos.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.relpy.daos.UserDAO;
import com.relpy.models.User;
import com.relpy.models.UserType;
import com.relpy.services.UserService;
import com.relpy.services.UserServiceImpl;

class UserServiceTest {

	private static User iuser;
	
	@Autowired
	private static UserService userService;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		iuser = new User();
		iuser.setPassword("password");
		iuser.setUsername("username");
		iuser.setDateCreated(new Date());
		iuser.setType(UserType.User);
		userService = new UserServiceImpl();
	}
	
	@Test
	void saveTest() {
		System.out.println(iuser);
		iuser = userService.registerUser(iuser);
		System.out.println(iuser);
		assertEquals(true, true);
	}
	
	@Test
	void loginTest() {
		System.out.println(iuser);
		iuser = userService.login(iuser);
		System.out.println(iuser);
		assertEquals(true, true);
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
