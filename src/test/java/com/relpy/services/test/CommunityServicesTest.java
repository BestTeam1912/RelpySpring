package com.relpy.services.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.relpy.daos.CommunityDAO;
import com.relpy.models.Community;
import com.relpy.services.CommunityService;
import com.relpy.services.CommunityServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommunityServicesTest {
 
    @Autowired
    private CommunityServiceImpl service;
    
    @MockBean
    private CommunityDAO dao;
    
	@Test
	public void getCommunitiesTest() {
		when(dao.findAll()).thenReturn(Stream
				.of(new Community(1L, "community1", "c1des", null, new Date()), new Community(2L, "community2", "c2des", null, new Date())).collect(Collectors.toList()));
		assertEquals(2, service.getAllCommunities().size());
	}
	
	@Test
	public void addCommunityTest() {
		Community com = new Community(1L, "community1", "c1des", null, new Date());
		when(dao.save(com)).thenReturn(com);
		assertEquals(com, service.addCommunity(com));
	}

}
