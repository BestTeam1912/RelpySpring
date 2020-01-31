package com.relpy.services;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.relpy.daos.ThreadDAO;
import com.relpy.models.Comment;
import com.relpy.models.Thread;
import com.relpy.models.User;

@Service
public class ThreadServiceImpl implements ThreadService {

	@Autowired
	private ThreadDAO threadRepository;
	
	@Value("${defaultMoney}")
	private int defaultMoney;

	@Override
	public Thread addThread(Thread thread) {
		thread.setDateCreated(new Date());
		return threadRepository.save(thread);
	}

	@Override
	public void deleteThread(Thread thread) {
		threadRepository.delete(thread);
	}
	
	@Override
	public Thread updateThread(Thread thread) {
		return threadRepository.save(thread);
	}

	@Override
	public List<Comment> getCommentsByThread(Thread thread) {
		return null;
	}

	@Override
	public int getUserCurrency(long threadId, long userId) {
		Thread thread = threadRepository.findById(threadId).get();
		Map<Long, Integer> moneyMap = thread.getMoneyMap();
		moneyMap.put(userId, defaultMoney);
		return moneyMap.get(userId);
	}

	@Override
	public Thread getThreadById(long id) {
		return threadRepository.findById(id).get();
	}

	@Override
	public List<Thread> getAllThreads() {
		return threadRepository.findAll();
	}

	@Override
	public void addUserToThread(long threadId, User user) {
		Thread thread = threadRepository.findById(threadId).get();
		Map<Long, Integer> moneyMap = thread.getMoneyMap();
		if(moneyMap.get(user.getId()) == null) {
			moneyMap.put(user.getId(), defaultMoney);
			updateThread(thread);
		}
	}

	@Override
	public void reduceUserCurrency(long threadId, User user, int amount) {
		getThreadById(threadId);
	}
}
