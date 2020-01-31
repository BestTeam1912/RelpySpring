package com.relpy.bos;

import com.relpy.models.Comment;

public interface CommentBO {
	public boolean isValidText(Comment comment) throws Exception;
	
	public boolean isValidToUpdate(Comment comment);
	
	public boolean enoughCharactersForComment(Comment comment, int cahrez);
}
