package com.revature.chatroomback.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.chatroomback.models.Comment;

@Repository
public interface CommentDAO extends JpaRepository<Comment,Integer>{
	
	@SuppressWarnings("unchecked")
	Comment save(Comment newComment);

	@Query("select u from Comment u where u.commentUser = :commentUser")
	List<Comment> findByCommentUser(@Param("commentUser") Integer commentUser);
	
	@Query("select u from Comment u where u.commentTable = :commentTable")
	List<Comment> findByCommentTable(@Param("commentTable") Integer commentTable);
	
	@Modifying
	@Query("delete from Comment where id = :commentId")
	void delete(@Param("commentId") Integer id);
	
}
