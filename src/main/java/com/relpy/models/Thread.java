package com.relpy.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Thread")
public class Thread {
	@Id
	@GeneratedValue
	private long id;
	private String title;
	@OneToMany
	List<Comment> comments;
	@OneToMany
	List<ActiveUser> activeUsers;
	@ManyToOne
	Community community;
	public Thread() {
		// TODO Auto-generated constructor stub
	}
	public Thread(long id, String title, List<Comment> comments, List<ActiveUser> activeUsers, Community community) {
		super();
		this.id = id;
		this.title = title;
		this.comments = comments;
		this.activeUsers = activeUsers;
		this.community = community;
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
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<ActiveUser> getActiveUsers() {
		return activeUsers;
	}
	public void setActiveUsers(List<ActiveUser> activeUsers) {
		this.activeUsers = activeUsers;
	}
	public Community getCommunity() {
		return community;
	}
	public void setCommunity(Community community) {
		this.community = community;
	}
	@Override
	public String toString() {
		return "Thread [id=" + id + ", title=" + title + ", comments=" + comments + ", activeUsers=" + activeUsers
				+ ", community=" + community + "]";
	}
	
}
