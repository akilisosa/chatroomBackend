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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.chatroomback.models.User;
import com.revature.chatroomback.service.UserService;


@RestController
@RequestMapping("User")
public class UserController {
	
Logger logger = LogManager.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	@PostMapping()
	public @ResponseBody ResponseEntity<HttpStatus> register(@RequestBody User obj){
		logger.info("Registered a new User with email", obj.getEmail());
		userService.registerUser(obj);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<HttpStatus> update(@PathVariable("id") Integer id,@RequestBody User user) {
		logger.info("UserController->update", id);
		userService.update(user);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@GetMapping()
	public @ResponseBody ResponseEntity<HttpStatus> list() {
		logger.error("somebody should not have been doing this");
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}

	@GetMapping("/{id}" )
	public User findOne(@PathVariable("id") Integer id) {
		return userService.findOne(id);
	}
	
	@PostMapping(value="/login/", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> findByEmailAndPassword(@RequestParam("username")String email,@RequestParam("password") String password) {
		User user = userService.findByEmailAndPassword(email, password);
		return new ResponseEntity<>(user, HttpStatus.OK);
		
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
		userService.delete(id);
		return new ResponseEntity<>(HttpStatus.GONE);
	}
	
	
}
