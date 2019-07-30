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
 
import com.revature.chatroomback.models.ChannelUsers;
import com.revature.chatroomback.service.ChannelUsersService;

@RestController
@RequestMapping("ChannelUsers")
public class ChannelUsersController {

	Logger logger = LogManager.getLogger(ChannelUsersController.class);
	
	@Autowired
	private ChannelUsersService channelUsersService;

	@PostMapping()
	public @ResponseBody  ResponseEntity<HttpStatus>  register(@RequestBody ChannelUsers obj){
		logger.info("UserController->save a new user", obj.getChannelUser());
		channelUsersService.registerChannelUsers(obj);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<HttpStatus> update(@PathVariable("id") Integer id,@RequestBody ChannelUsers user) {
		logger.info("UserController->update" + id);
		channelUsersService.update(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<ChannelUsers>> properList() {
		return new ResponseEntity<>(channelUsersService.list(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
		channelUsersService.delete(id);
		return new ResponseEntity<>(HttpStatus.GONE);
	}
}
