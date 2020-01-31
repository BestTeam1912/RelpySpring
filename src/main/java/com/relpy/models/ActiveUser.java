package com.relpy.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//@Entity
//@Table(name = "p2_active")
public class ActiveUser {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long id;
//	private int characterBank;
//	@ManyToOne
//	@JoinColumn(name = "Active_User", nullable = true)
//	private User user;
//	@ManyToOne
//	@JoinColumn(name = "AU_thread_ref", nullable = true)
//	private Thread mythread;
//	public ActiveUser() {
//		// TODO Auto-generated constructor stub
//	}
//	public ActiveUser(long id, int characterBank, User user, Thread mythread) {
//		super();
//		this.id = id;
//		this.characterBank = characterBank;
//		this.user = user;
//		this.mythread = mythread;
//	}
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public int getCharacterBank() {
//		return characterBank;
//	}
//
//	public void setCharacterBank(int characterBank) {
//		this.characterBank = characterBank;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public Thread getMythread() {
//		return mythread;
//	}
//
//	public void setMythread(Thread mythread) {
//		this.mythread = mythread;
//	}
//
//	@Override
//	public String toString() {
//		return "ActiveUser [id=" + id + ", characterBank=" + characterBank + ", user=" + user + ", mythread=" + mythread
//				+ "]";
//	}
}
