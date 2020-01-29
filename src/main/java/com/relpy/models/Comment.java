package com.relpy.models;

import java.util.Date;
import java.util.List;

public class Comment {
	private int id;
	private String text;
	private List<Comment> replies;
	private Thread thread;
	private Date dateCreated;
	private String activeUser;
	private Comment replyingTo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<Comment> getReplies() {
		return replies;
	}
	public void setReplies(List<Comment> replies) {
		this.replies = replies;
	}
	public Thread getThread() {
		return thread;
	}
	public void setThread(Thread thread) {
		this.thread = thread;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getActiveUser() {
		return activeUser;
	}
	public void setActiveUser(String activeUser) {
		this.activeUser = activeUser;
	}
	public Comment getReplyingTo() {
		return replyingTo;
	}
	public void setReplyingTo(Comment replyingTo) {
		this.replyingTo = replyingTo;
	}
	public Comment(int id, String text, List<Comment> replies, Thread thread, Date dateCreated, String activeUser,
			Comment replyingTo) {
		super();
		this.id = id;
		this.text = text;
		this.replies = replies;
		this.thread = thread;
		this.dateCreated = dateCreated;
		this.activeUser = activeUser;
		this.replyingTo = replyingTo;
	}
	public Comment() {
		super();
	}
}
