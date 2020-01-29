package com.relpy.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "p2_comment")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String text;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "replyingTo")
	private List<Comment> replies;
	@ManyToOne
	@JoinColumn(name = "comment_thread_ref", nullable = true)
	private Thread thread;
	@ManyToOne
	@JoinColumn(name = "comment_user_ref", nullable = true)
	private User user;
	@ManyToOne
	@JoinColumn(name = "replyTo", nullable = true)
	private Comment replyingTo;
	private Date dateCreated;
	
	public Comment() {
	}

	public Comment(long id, String text, List<Comment> replies, Thread thread, User user, Comment replyingTo,
			Date dateCreated) {
		super();
		this.id = id;
		this.text = text;
		this.replies = replies;
		this.thread = thread;
		this.user = user;
		this.replyingTo = replyingTo;
		this.dateCreated = dateCreated;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Comment getReplyingTo() {
		return replyingTo;
	}

	public void setReplyingTo(Comment replyingTo) {
		this.replyingTo = replyingTo;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
}
