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
@Table(name="ActiveUser")
public class ActiveUser {
	@Id
	@GeneratedValue
	private long id;
	private int characterBank;
	@ManyToOne
	private User user;
	@ManyToOne
	private Thread thread;
	private Date dateCreated;
	public ActiveUser() {
		// TODO Auto-generated constructor stub
	}
	public ActiveUser(long id, int characterBank, User user, Thread thread, Date dateCreated) {
		super();
		this.id = id;
		this.characterBank = characterBank;
		this.user = user;
		this.thread = thread;
		this.dateCreated = dateCreated;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCharacterBank() {
		return characterBank;
	}
	public void setCharacterBank(int characterBank) {
		this.characterBank = characterBank;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	@Override
	public String toString() {
		return "ActiveUser [id=" + id + ", characterBank=" + characterBank + ", user=" + user + ", thread=" + thread
				+ ", dateCreated=" + dateCreated + "]";
	}
}
