package com.relpy.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="User")
public class User {
	@Id
	@GeneratedValue
	private long id;
	private String username;
	private String password;
	private Date dateCreated;
	private UserType type; 
	@OneToMany
	private List<ActiveUser> activeUsers;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(long id, String username, String password, Date dateCreated, UserType type,
			List<ActiveUser> activeUsers) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.dateCreated = dateCreated;
		this.type = type;
		this.activeUsers = activeUsers;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public UserType getType() {
		return type;
	}
	public void setType(UserType type) {
		this.type = type;
	}
	public List<ActiveUser> getActiveUsers() {
		return activeUsers;
	}
	public void setActiveUsers(List<ActiveUser> activeUsers) {
		this.activeUsers = activeUsers;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", dateCreated=" + dateCreated
				+ ", type=" + type + ", activeUsers=" + activeUsers + "]";
	}
}
