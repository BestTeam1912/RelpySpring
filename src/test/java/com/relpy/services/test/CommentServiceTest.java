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

import com.relpy.daos.CommentDAO;
import com.relpy.models.Comment;
import com.relpy.services.CommentServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class CommentServiceTest {

    @Autowired
    private CommentServiceImpl service;
    
    @MockBean
    private CommentDAO dao;
    
	@Test
	public void getCommentsTest() {
		when(dao.findAll()).thenReturn(Stream
				.of(new Comment(1L, "comment1text", null, null, new Date()), 
						new Comment(2L, "comment2text", null, null, new Date())).collect(Collectors.toList()));
		assertEquals(2, service.findComments().size());
	}
	
	@Test
	public void addCommentTest() {
		Comment comment = new Comment(1L, "comment1text", null, null, new Date());
		when(dao.save(comment)).thenReturn(comment);
		assertEquals(comment, service.addComment(comment));
	}

}
