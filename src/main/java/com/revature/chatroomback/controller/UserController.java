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

import com.revature.chatroomback.models.User;
import com.revature.chatroomback.service.UserService;


@RestController
@RequestMapping("User")
public class UserController {
	
Logger logger = LogManager.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	@PostMapping()
	public @ResponseBody void register(@RequestBody User obj){
		logger.info("Registered a new User with email" + obj.getEmail());
		userService.registerUser(obj);
	}

	@PutMapping("/{id}")
	public @ResponseBody void update(@PathVariable("id") Integer id,@RequestBody User user) {
		logger.info("UserController->update" + id);
		userService.update(user);
	}

	@GetMapping()
	public List<User> list() {
		List<User> list = userService.list();
		return list;
	}

	@GetMapping("/{id}")
	public User findOne(@PathVariable("id") Integer id) {
		return userService.findOne(id);
	}
	

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		userService.delete(id);
	}
	
	
}
