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
@Table(name = "p2_thread")
public class Thread {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String title;
	private String description;
	@ManyToOne
	@JoinColumn(name = "community_ref", nullable = true)
	private Community community;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "thread")
	private List<Comment> commentList;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mythread")
	private List<ActiveUser> activeUsers;
	private Date dateCreated;
	
	public Thread() {
		// TODO Auto-generated constructor stub
	}

	public Thread(long id, String title, String description, Community community, List<Comment> commentList,
			List<ActiveUser> activeUsers, Date dateCreated) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.community = community;
		this.commentList = commentList;
		this.activeUsers = activeUsers;
		this.dateCreated = dateCreated;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Community getCommunity() {
		return community;
	}

	public void setCommunity(Community community) {
		this.community = community;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public List<ActiveUser> getActiveUsers() {
		return activeUsers;
	}

	public void setActiveUsers(List<ActiveUser> activeUsers) {
		this.activeUsers = activeUsers;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "Thread [id=" + id + ", title=" + title + ", description=" + description + ", community=" + community
				+ ", commentList=" + commentList + ", activeUsers=" + activeUsers + ", dateCreated=" + dateCreated
				+ "]";
	}
}
