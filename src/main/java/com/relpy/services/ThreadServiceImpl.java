package com.relpy.services;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.relpy.daos.ThreadDAO;
import com.relpy.exceptions.InsufficientFundsException;
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
	public void deleteThreadById(Long id) {
		// TODO Auto-generated method stub
		threadRepository.deleteById(id);
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
	public void reduceUserCurrency(long threadId, long userId, int amount) {
		Thread thread = getThreadById(threadId);
		Map<Long, Integer> moneyMap = thread.getMoneyMap();	
		System.out.println(moneyMap);
		if(moneyMap.get(userId) != null) {
			int currentMoney = moneyMap.get(userId);
			if(currentMoney - amount < 0) {
				throw new InsufficientFundsException("User Did Not Have Enough Currency To Comment.");
			}else {
				moneyMap.put(userId, currentMoney - amount);
				updateThread(thread);
			}
		}
	}
}
