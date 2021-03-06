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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "p2_comment")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull(message = "This is a bad type")
	@NotEmpty(message = "Please add some Cahrez to the message before posting")
	private String text;
	@OneToMany(fetch = FetchType.LAZY)//, mappedBy = "replyingTo")
	private List<Comment> replies;
	@ManyToOne
	@JoinColumn(name = "comment_user_ref", nullable = true)
	private User user;
	private Date dateCreated;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(long id,
			@NotNull(message = "This is a bad type") @NotEmpty(message = "Please add some Cahrez to the message before posting") String text,
			List<Comment> replies, User user, Date dateCreated) {
		super();
		this.id = id;
		this.text = text;
		this.replies = replies;
		this.user = user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
}
