package com.relpy.services.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.relpy.daos.UserDAO;
import com.relpy.models.User;
import com.relpy.models.UserType;
import com.relpy.services.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserServiceImpl service;
    
    @MockBean
    private UserDAO dao;
	
	@Test
	public void getUserByName() {
		User user = new User(1L, "username", "password", UserType.User, new Date());
		when(dao.findByUsername("username")).thenReturn(user);
		assertEquals(user, service.getUserByName("username"));
	}

}
