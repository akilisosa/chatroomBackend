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

import com.revature.chatroomback.models.Channel;
import com.revature.chatroomback.service.ChannelService;

@RestController
@RequestMapping("Channel")
public class ChannelController {
	
	Logger logger = LogManager.getLogger(ChannelController.class);

	@Autowired
	private ChannelService channelService;

	@PostMapping()
	public @ResponseBody ResponseEntity<HttpStatus> register(@RequestBody Channel channel) {
		logger.info("ChannelController->resgistered a new user");
		channelService.registerChannel(channel);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<HttpStatus> update(@PathVariable("id") Integer id,@RequestBody Channel channel) {
		logger.info("ChannelController->update");
		channelService.update(channel);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping()
	public List<Channel> list() {
		logger.error("ChannelController->listed all channels should not have been called");
		return channelService.list();
	}
	
	@GetMapping(value="/type/{type}", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<Channel>> listByType(@PathVariable("type") String type) {
		logger.info("ChannelController->listed by channel types");
		return new ResponseEntity<>(channelService.listByType(type), HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
		logger.info("ChannelController->deleted a channel");
		channelService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
