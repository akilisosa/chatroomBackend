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

import com.revature.chatroomback.models.ChannelUsers;
import com.revature.chatroomback.service.ChannelUsersService;

@RestController
@RequestMapping("ChannelUsers")
public class ChannelUsersController {

	Logger logger = LogManager.getLogger(ChannelUsersController.class);
	
	@Autowired
	private ChannelUsersService channelUsersService;

	@PostMapping()
	public @ResponseBody void register(@RequestBody ChannelUsers obj){
		logger.info("UserController->save a new user" + obj.getChannelUser());
		channelUsersService.registerChannelUsers(obj);
	}

	@PutMapping("/{id}")
	public @ResponseBody void update(@PathVariable("id") Integer id,@RequestBody ChannelUsers user) {
		System.out.println("UserController->update" + id);
		channelUsersService.update(user);
	}

	@GetMapping()
	public List<ChannelUsers> list() {
		List<ChannelUsers> list = channelUsersService.list();
		return list;
	}

	@GetMapping("/{id}")
	public ChannelUsers findOne(@PathVariable("id") Integer id) {
		ChannelUsers user = channelUsersService.findOne(id);
		return user;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		channelUsersService.delete(id);
	}
}
