package com.relpy.services;

import java.util.List;

import com.relpy.models.Comment;

public interface CommentService {
	public List<Comment> findComments();

	public Comment addComment(Comment comment);

	public Comment getCommentById(long id);

	public Comment updateComment(Comment comment);

	public void deleteCommentById(long id);
}
