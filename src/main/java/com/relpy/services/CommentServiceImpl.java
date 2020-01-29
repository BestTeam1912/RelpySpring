package com.relpy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.relpy.daos.CommentDAO;
import com.relpy.models.Comment;

public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO commentDao;
	
	@Override
	public List<Comment> findCommentsInThreadId(int id) {
		return commentDao.findByThreadId(id);
	}

}
