package com.relpy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relpy.bos.CommentBO;
import com.relpy.bos.CommentBoImpl;
import com.relpy.daos.CommentDAO;
import com.relpy.models.Comment;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO commentDao;
	
	private CommentBO commentBo = new CommentBoImpl();
	
	@Override
	public List<Comment> findComments() {
		return commentDao.findAll();
	}
	
	@Override
	public Comment getCommentById(long id) {
		return commentDao.findById(id).get();
	}

	@Override
	public Comment addComment(Comment comment) throws Exception {
		if(commentBo.validateToUpdate(comment)) {
			throw new Exception("uh oh: this comment is already around");
		}
		if(commentBo.validateText(comment)) {
			return commentDao.save(comment);
		}else {
			throw new Exception("Something about the text makes it invalid for posting");
		}
		
	}

	@Override
	public Comment updateComment(Comment comment) {
		return commentDao.save(comment);
	}
	
	@Override
	public void deleteCommentById(long id) {
		commentDao.deleteById(id);
	}

}
