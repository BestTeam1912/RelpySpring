package com.relpy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relpy.daos.ThreadDAO;
import com.relpy.models.Comment;
import com.relpy.models.Thread;

@Service
public class ThreadServiceImpl implements ThreadService {

	@Autowired
	private ThreadDAO threadRepository;

	@Override
	public Thread addThread(Thread thread) {
		return threadRepository.save(thread);
	}

	@Override
	public void deleteThread(Thread thread) {
		threadRepository.delete(thread);
	}

	@Override
	public List<Comment> getCommentsByThread(Thread thread) {
		// TODO Auto-generated method stub
		return null;
	}



}
