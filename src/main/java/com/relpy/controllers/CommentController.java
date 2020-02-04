package com.relpy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relpy.models.Comment;
import com.relpy.services.CommentService;

@CrossOrigin(origins = "http://relpyrevature.s3-website.us-east-2.amazonaws.com:4200")
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
	
	@GetMapping("/{id}")
	public Comment getCommentById(@PathVariable("id") int id){
		return commentService.getCommentById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCommentById(@PathVariable("id") int id){
		commentService.deleteCommentById(id);
	}
	
	@PostMapping("/add")
	public Comment addComment(@RequestBody Comment comment){
		return commentService.addComment(comment);
	}
	
	@PutMapping("/update")
	public Comment updateComment(@RequestBody Comment comment) {
		return commentService.updateComment(comment);
	}
}
