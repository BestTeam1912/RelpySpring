package com.relpy.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Comment")
public class Comment {
	@Id
	@GeneratedValue
	private int id;
	private String text;
	@OneToMany()
	private List<Comment> replies;
	@ManyToOne
	private Thread thread;
	private Date dateCreated;
	private ActiveUser user;
	@ManyToOne
	private Comment replyingTo;

	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(int id, String text, List<Comment> replies, Thread thread, Date dateCreated, ActiveUser user,
			Comment replyingTo) {
		super();
		this.id = id;
		this.text = text;
		this.replies = replies;
		this.thread = thread;
		this.dateCreated = dateCreated;
		this.user = user;
		this.replyingTo = replyingTo;
	}

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

	public ActiveUser getUser() {
		return user;
	}

	public void setUser(ActiveUser user) {
		this.user = user;
	}

	public Comment getReplyingTo() {
		return replyingTo;
	}

	public void setReplyingTo(Comment replyingTo) {
		this.replyingTo = replyingTo;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", text=" + text + ", replies=" + replies + ", thread=" + thread + ", dateCreated="
				+ dateCreated + ", user=" + user + ", replyingTo=" + replyingTo + "]";
	}
}
