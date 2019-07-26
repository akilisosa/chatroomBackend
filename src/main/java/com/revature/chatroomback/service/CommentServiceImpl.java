package com.revature.chatroomback.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.chatroomback.dao.CommentDAO;
import com.revature.chatroomback.models.Comment;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentDAO commentDAO;
	
	@Transactional
	public void save(Comment newComment) {
		commentDAO.save(newComment);
	}

	@Transactional
	public void registerComment(Comment newComment) {
		commentDAO.save(newComment);
	}

	@Transactional
	public List<Comment> list() {
		//commentDAO.list();
		return null;
	}

	@Transactional
	public List<Comment> findCommentUser(Integer commentUser) {
		commentDAO.findByCommentUser(commentUser);
		return null;
	}

	@Transactional
	public List<Comment> findByCommentTable(Integer commentTable) {
		commentDAO.findByCommentTable(commentTable);
		return null;
	}

	@Transactional
	public void delete(Integer commentId) {
		commentDAO.delete(commentId);
		
	}

	@Transactional
	public void update(Comment obj) {
		commentDAO.save(obj);
		
	}

}
