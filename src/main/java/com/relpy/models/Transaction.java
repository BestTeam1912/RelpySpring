package com.relpy.models;

public class Transaction {
	private long threadId;
	private long userId;
	private int amount;
	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	public Transaction(long threadId, long userId, int amount) {
		super();
		this.threadId = threadId;
		this.userId = userId;
		this.amount = amount;
	}
	public long getThreadId() {
		return threadId;
	}
	public void setThreadId(long threadId) {
		this.threadId = threadId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
