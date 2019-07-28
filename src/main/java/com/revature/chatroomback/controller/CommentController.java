package com.revature.chatroomback.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	public @ResponseBody ResponseEntity<HttpStatus> register(@RequestBody Comment newComment) {
		logger.info("this user" + newComment.getCommentUser() + "made a new comment");
		commentService.registerComment(newComment);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<HttpStatus> update(@PathVariable("id") Integer id, @RequestBody Comment newComment){
		logger.info("there isn't a feature for this yet so it shouldn't be called");
		commentService.update(newComment);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="/channel/{commentTable}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Comment>> listByTable(Integer commentTable){
		logger.info("channel comments is being called.");
		return new ResponseEntity<>(commentService.findByCommentTable(commentTable),HttpStatus.OK);
	}
	
	@GetMapping(value="/user/{commentUser}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Comment>> listByUser(Integer commentUser){
		logger.info("user looks at their comments");
		return new ResponseEntity<>(commentService.findCommentUser(commentUser), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
		commentService.delete(id);
		return new ResponseEntity<>(HttpStatus.GONE);
	}

}
