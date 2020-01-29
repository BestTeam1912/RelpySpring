package com.relpy.comment.service;

import java.util.List;

import com.relpy.comment.to.Comment;

public interface CommentService {
	public List<Comment> findCommentsInThreadId(int id);
}
