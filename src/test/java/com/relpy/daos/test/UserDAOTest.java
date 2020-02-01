package com.relpy.daos.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.relpy.daos.UserDAO;
import com.relpy.models.User;
import com.relpy.models.UserType;

class UserDAOTest {

	private static User iuser;
	
	@Autowired
	private static UserDAO userDao;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		iuser = new User();
		iuser.setPassword("password");
		iuser.setUsername("username");
		iuser.setDateCreated(new Date());
		iuser.setType(UserType.User);
		
	}
	
	@Test
	void saveUserTest() {
		assertEquals(new NullPointerException(), (userDao.save(iuser).getId() < 99999999999999l));
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
