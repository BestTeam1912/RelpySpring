package com.relpy.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "p2_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String username;
	private String password;
	private UserType type;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<ActiveUser> activeUsers;
	private Date dateCreated;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(long id, String username, String password, UserType type, List<ActiveUser> activeUsers,
			Date dateCreated) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.type = type;
		this.activeUsers = activeUsers;
		this.dateCreated = dateCreated;
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

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", type=" + type
				+ ", activeUsers=" + activeUsers + ", dateCreated=" + dateCreated + "]";
	}
}
