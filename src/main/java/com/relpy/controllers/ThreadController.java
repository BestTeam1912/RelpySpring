package com.relpy.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relpy.exceptions.InvalidActionException;
import com.relpy.models.Comment;
import com.relpy.models.Community;
import com.relpy.models.Thread;
import com.relpy.models.Transaction;
import com.relpy.models.User;
import com.relpy.services.CommentService;
import com.relpy.services.CommunityService;
import com.relpy.services.ThreadService;
import com.relpy.services.UserService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/thread")
public class ThreadController {
	@Autowired
	private ThreadService threadService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private CommunityService communityService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping(path="/add")
	public Thread addThread(@RequestBody Thread thread) {
		return threadService.addThread(thread);
	}
	
	@PostMapping("/add/comment/{threadId}")
	public void addComment(@RequestBody Comment comment, @PathVariable long threadId) {
		int commentLength = comment.getText().length();
		User user = comment.getUser();
		int currency = threadService.getUserCurrency(threadId, user.getId());
		threadService.reduceUserCurrency(threadId, user.getId(), commentLength);
		Thread thread = threadService.getThreadById(threadId);
		thread.getCommentList().add(comment);
		commentService.addComment(comment);
		threadService.updateThread(thread);
	}
	
	@PostMapping("/reply/{threadId}/{commentId}")
	public void replyToComment(@PathVariable long commentId, @PathVariable long threadId ,@RequestBody Comment reply) {
		int replyLength = reply.getText().length();
		User user = reply.getUser();
		
		Comment comment = commentService.getCommentById(commentId);
		User originalCommentUser = comment.getUser();
		if(originalCommentUser.getId() == user.getId()) {
			throw new InvalidActionException("You cannot reply to yourself!!!");
		}
		threadService.reduceUserCurrency(threadId, user.getId(), replyLength);
		commentService.addComment(reply);
				
		Thread thread = threadService.getThreadById(threadId);
		thread.getCommentList().add(reply);
		threadService.updateThread(thread);
		
		comment.getReplies().add(reply);
		commentService.updateComment(comment);
		
		
		threadService.resetUserCurrency(threadId, originalCommentUser.getId());
	}
	
	@GetMapping("/get")
	public List<Thread> getAllThreads(){
		return threadService.getAllThreads();
	}
	
	@GetMapping("/get/{id}")
	public Thread getThreadById(@PathVariable long id) {
		return threadService.getThreadById(id);
	}	
	
	@GetMapping("/get/comments/{threadId}")
	public List<Comment> getThreadComments(@PathVariable long threadId){
		Thread thread = threadService.getThreadById(threadId);
		return thread.getCommentList();
	}
	
	@GetMapping("/get/currency/{threadId}/{userId}")
	public int getUserCurrency(@PathVariable long threadId, @PathVariable long userId ) {
		return threadService.getUserCurrency(threadId, userId);
	}
	
	@PostMapping("/add/user/{threadId}")
	public void addUserToThread(@PathVariable long threadId, @RequestBody User user) {
		threadService.addUserToThread(threadId, user);
	}
	
	@PutMapping("/reduce/currency")
	public void reduceUserCurrency(@RequestBody Transaction transaction) {
		threadService.reduceUserCurrency(transaction.getThreadId(), transaction.getUserId(), transaction.getAmount());
	}
	
	@DeleteMapping("/delete/{threadid}/{comid}")
	public void deleteThreadById(@PathVariable("threadid") Long threadid, @PathVariable("comid") Long comid){
		Community com=communityService.getCommunityByID(comid);
		com.getThreads().remove(threadService.getThreadById(threadid));
		threadService.deleteThreadById(threadid);
	}
	
}
