package com.relpy.services;

import java.util.List;

import com.relpy.models.Comment;
import com.relpy.models.Thread;
import com.relpy.models.User;

public interface ThreadService {
	Thread addThread(Thread thread);
	List<Comment> getCommentsByThread(Thread thread);
	Thread getThreadById(long id);
	List<Thread> getAllThreads();
	Thread updateThread(Thread thread);
	int getUserCurrency(long threadId, long userId);
	void addUserToThread(long threadId, User user);
	void reduceUserCurrency(long threadId, long userId, int amount);
	void deleteThreadById(Long id);
}
