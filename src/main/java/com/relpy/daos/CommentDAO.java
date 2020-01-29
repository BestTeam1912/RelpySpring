package com.relpy.daos;

import java.util.List;

import com.relpy.models.Comment;

public interface CommentDAO {
	public List<Comment> findByThreadId(int id);
}
