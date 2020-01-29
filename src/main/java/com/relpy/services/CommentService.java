package com.relpy.services;

import java.util.List;

import com.relpy.models.Comment;

public interface CommentService {
	public List<Comment> findCommentsInThreadId(int id);
}
