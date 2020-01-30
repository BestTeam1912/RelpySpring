package com.relpy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relpy.models.Comment;
import com.relpy.services.CommentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/comment")
public class CommentController {
	@Autowired
	private CommentService commentService;
	
//	@GetMapping("/thread/{id}")
//	public List<Comment> getCommentsByThreadId(@PathVariable("id") int id){
//		return commentService.findCommentsInThreadId(id);
//	}
	
	@GetMapping("/all")
	public List<Comment> getAllComments(){
		return commentService.findComments();
	}
	
	@PostMapping("/add")
	public Comment addComment(@RequestBody Comment comment) {
		return commentService.addComment(comment);
	}
}
