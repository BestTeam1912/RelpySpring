package com.relpy.services;

import java.util.List;

import com.relpy.models.Comment;
import com.relpy.models.Thread;

public interface ThreadService {
	Thread addThread(Thread thread);
	void deleteThread(Thread thread);
	List<Comment> getCommentsByThread(Thread thread);
	Thread updateThread(Thread thread);
}
