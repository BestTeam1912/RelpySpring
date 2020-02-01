package com.relpy.daos.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.relpy.models.Comment;
import com.relpy.services.CommentService;
import com.relpy.services.CommentServiceImpl;

class CommentServiceTest {
	
	static CommentService commentService = new CommentServiceImpl();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Comment comment = new Comment();
		comment.setText("This is the initial comment");
		comment.setReplies(new ArrayList<Comment>());
	}
	
	@Test
	void addCommentTest() {
		Comment comment = new Comment();
		comment.setText("This is the initial comment");
		comment.setReplies(new ArrayList<Comment>());
		comment = commentService.addComment(comment);
		assertEquals(comment, commentService.getCommentById(comment.getId()));
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
