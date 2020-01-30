package com.relpy.models;

import java.util.ArrayList;
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
@Table(name = "p2_community")
public class Community {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String title;
	private String description;
	@OneToMany(fetch = FetchType.EAGER)//, mappedBy = "community")
	private List<Thread> threads;
	private Date dateCreated;

	public Community() {
		// TODO Auto-generated constructor stub
	}

	public Community(long id, String title, String description, List<Thread> threads, Date dateCreated) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.threads = threads;
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

	public List<Thread> getThreads() {
		return threads;
	}

	public void setThreads(List<Thread> threads) {
		this.threads = threads;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "Community [id=" + id + ", title=" + title + ", description=" + description + ", threads=" + threads
				+ ", dateCreated=" + dateCreated + "]";
	}
}
