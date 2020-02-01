package com.relpy.bos;

import com.relpy.models.Comment;

public class CommentBoImpl implements CommentBO {
	
	//@Value("${defaultMoney}")
	private int cahrez = 255;
	
	@Override
	public boolean validateText(Comment comment) throws Exception {
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
	public boolean validateToUpdate(Comment comment) {
//		if(comment.getId() < 10) {
//			return false;
//		}
		return true;
	}

	@Override
	public boolean validateEnoughCharactersForComment(Comment comment, int cahrez) {
		if(comment.getText().length() < cahrez && comment.getText().length() < this.cahrez) {
			return true;
		}
		return false;
	}
}
