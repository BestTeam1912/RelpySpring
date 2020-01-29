package com.relpy.comment.dao;

import java.util.List;

import com.relpy.comment.to.Comment;

public interface CommentDAO {
	public List<Comment> findByThreadId(int id);
}
