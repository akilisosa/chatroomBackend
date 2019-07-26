package com.revature.chatroomback.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.chatroomback.models.Comment;
import com.revature.chatroomback.service.CommentService;

@RestController
@RequestMapping("Comment")
public class CommentController {
	
	Logger logger = LogManager.getLogger(CommentController.class);
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping()
	public @ResponseBody void register(@RequestBody Comment newComment) {
		logger.info("this user" + newComment.getCommentUser() + "made a new comment");
		commentService.registerComment(newComment);
	}
	
	@PutMapping("/{id}")
	public @ResponseBody void update(@PathVariable("id") Integer id, @RequestBody Comment newComment){
		logger.info("there isn't a feature for this yet");
		commentService.update(newComment);
	}

	@GetMapping()
	public List<Comment> list() {
		logger.info("somebody pulled the whole list for some reason");
		List<Comment> list = commentService.list();
		return list;
	}
	
	@GetMapping("/channel/{commentTable}")
	public List<Comment> listByTable(Integer commentTable){
		logger.info("channel "+ commentTable + "comments is being called.");
		return commentService.findByCommentTable(commentTable);
	}
	
	@GetMapping("/user/{commentUser}")
	public List<Comment> listByUser(Integer commentUser){
		logger.info("this user " + commentUser +  " looks at their comments");
		return commentService.findCommentUser(commentUser);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		commentService.delete(id);
	}

}
