package com.relpy.bos;

import org.springframework.beans.factory.annotation.Value;

import com.relpy.models.Comment;

public class CommentBoImpl implements CommentBO {
	
	//@Value("${defaultMoney}")
	private int cahrez = 255;
	
	@Override
	public boolean isValidText(Comment comment) throws Exception {
		if(comment.getText().length() == 0) {
			return false;
		}
		System.out.println("cahrez: "+cahrez);
		if(comment.getText().length() > cahrez) {
			return false;
		}
		return true;
	}

	@Override
	public boolean isValidToUpdate(Comment comment) {
		if(comment.getId() < 10) {
			return false;
		}
		return true;
	}

	@Override
	public boolean enoughCharactersForComment(Comment comment, int cahrez) {
		if(comment.getText().length() < cahrez && comment.getText().length() < this.cahrez) {
			return true;
		}
		return false;
	}
}
