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

import com.relpy.daos.ThreadDAO;
import com.relpy.models.Thread;
import com.relpy.services.ThreadServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class ThreadServiceTest {

    @Autowired
    private ThreadServiceImpl service;
    
    @MockBean
    private ThreadDAO dao;
    
	@Test
	public void getThreadsTest() {
		when(dao.findAll()).thenReturn(Stream
				.of(new Thread(1L, "thread1", "thread1description", null, null, new Date()),
						new Thread(2L, "thread2", "thread2description", null, null, new Date())).collect(Collectors.toList()));
		assertEquals(2, service.getAllThreads().size());
	}
	
	@Test
	public void addThreadTest() {
		Thread thread = new Thread(1L, "thread1", "thread1description", null, null, new Date());
		when(dao.save(thread)).thenReturn(thread);
		assertEquals(thread, service.addThread(thread));
	}
}
