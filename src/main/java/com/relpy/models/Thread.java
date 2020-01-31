package com.relpy.models;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.relpy.models.User;

@Entity
@Table(name = "p2_thread")
public class Thread {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String title;
	private String description;
//	@ManyToOne
//	@JoinColumn(name = "community_ref", nullable = true)
//	private Community community;
	@OneToMany(fetch = FetchType.LAZY)//, mappedBy = "thread")
	private List<Comment> commentList;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name="user_money_mapping", 
			joinColumns = {@JoinColumn(name="thread_id", referencedColumnName = "id")})
	@MapKeyColumn(name = "user_id")
	@Column(name = "currency")
	private Map<User, Integer> moneyMap;
	private Date dateCreated;
	
	public Thread() {}

	public Thread(long id, String title, String description, List<Comment> commentList, Map<User, Integer> moneyMap,
			Date dateCreated) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.commentList = commentList;
		this.moneyMap = moneyMap;
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

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public Map<User, Integer> getMoneyMap() {
		return moneyMap;
	}

	public void setMoneyMap(Map<User, Integer> moneyMap) {
		this.moneyMap = moneyMap;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
}
