package com.relpy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relpy.daos.CommentDAO;
import com.relpy.models.Comment;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO commentDao;
	
	@Override
	public List<Comment> findComments() {
		return commentDao.findAll();
	}
	
	@Override
	public Comment getCommentById(int id) {
		return commentDao.findById(id).get();
	}

	@Override
	public Comment addComment(Comment comment) {
		return commentDao.save(comment);
	}

	@Override
	public Comment updateComment(Comment comment) {
		return commentDao.save(comment);
	}
	
	@Override
	public void deleteCommentById(int id) {
		commentDao.deleteById(id);
	}

}
