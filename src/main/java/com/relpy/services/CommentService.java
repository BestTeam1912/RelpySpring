package com.relpy.services;

import java.util.List;

import com.relpy.models.Comment;

public interface CommentService {
	public List<Comment> findComments();

	public Comment addComment(Comment comment);

	public Comment findCommentById(int id);
}
