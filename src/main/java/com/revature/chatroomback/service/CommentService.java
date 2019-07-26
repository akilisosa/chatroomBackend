package com.revature.chatroomback.service;

import java.util.List;

import com.revature.chatroomback.models.Comment;

public interface CommentService {

	void save(Comment newComment);
	
	void registerComment(Comment obj);

	List<Comment> list();
	
	List<Comment> findCommentUser(Integer commentUser);
	
	List<Comment> findByCommentTable(Integer commentTable);
	
	void delete(Integer commentId);

	void update(Comment obj);

}
