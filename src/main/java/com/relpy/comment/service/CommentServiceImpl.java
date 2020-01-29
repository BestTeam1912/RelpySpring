package com.relpy.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.relpy.comment.dao.CommentDAO;
import com.relpy.comment.to.Comment;

public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO commentDao;
	
	@Override
	public List<Comment> findCommentsInThreadId(int id) {
		return commentDao.findByThreadId(id);
	}

}
