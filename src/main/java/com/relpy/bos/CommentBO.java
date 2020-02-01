package com.relpy.bos;

import com.relpy.models.Comment;

public interface CommentBO {
	public boolean validateText(Comment comment) throws Exception;
	
	public boolean validateToUpdate(Comment comment);
	
	public boolean validateEnoughCharactersForComment(Comment comment, int cahrez);
}
