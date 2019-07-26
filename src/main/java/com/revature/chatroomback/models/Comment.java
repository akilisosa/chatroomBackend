package com.revature.chatroomback.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CHAT_COMMENTS")
public class Comment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6172995470989181857L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chat_comment_gen")
	@SequenceGenerator(name = "chat_comment_gen", sequenceName = "chat_comment_seq", allocationSize = 1)
	@Column(name = "COMMENT_ID")
	private Integer id;
	
	@Column(name = "Comment_user")
	private Integer commentUser;
	
	@Column(name = "Comment_content")
	private String commentContent;
	
	@Column(name = "Comment_table")
	private Integer commentTable;
	
	
	
	@Column(name = "Comment_date")
	private String commentDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCommentUser() {
		return commentUser;
	}

	public void setCommentUser(Integer commentUser) {
		this.commentUser = commentUser;
	}

	public Integer getCommentTable() {
		return commentTable;
	}

	public void setCommentTable(Integer commentTable) {
		this.commentTable = commentTable;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", commentUser=" + commentUser + ", commentTable=" + commentTable
				+ ", commentDate=" + commentDate + "]";
	}

	public Comment(Integer id, Integer commentUser, Integer commentTable, String commentDate) {
		super();
		this.id = id;
		this.commentUser = commentUser;
		this.commentTable = commentTable;
		this.commentDate = commentDate;
	}

	public Comment() {
		super();
	}
	
	
	
}
