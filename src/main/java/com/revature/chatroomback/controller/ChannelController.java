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

import com.revature.chatroomback.models.Channel;
import com.revature.chatroomback.service.ChannelService;

@RestController
@RequestMapping("Channel")
public class ChannelController {
	
	Logger logger = LogManager.getLogger(ChannelController.class);

	@Autowired
	private ChannelService channelService;

	@PostMapping()
	public @ResponseBody void register(@RequestBody Channel channel) {
		logger.info("ChannelController->resgistered a new user");
		channelService.registerChannel(channel);
	}

	@PutMapping("/{id}")
	public @ResponseBody void update(@PathVariable("id") Integer id,@RequestBody Channel channel) {
		logger.info("ChannelController->update");
		channelService.update(channel);
	}

	@GetMapping()
	public List<Channel> list() {
		logger.info("ChannelController->listed all channels");
		List<Channel> list = channelService.list();
		return list;
	}
	
	@GetMapping("/{type}")
	public List<Channel> listByType(@PathVariable("type") String type) {
		logger.info("ChannelController->listed by channel types");
		List<Channel> channels = channelService.listByType(type);
		return channels;
	}


	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		logger.info("ChannelController->deleted a channel");
		channelService.delete(id);
	}

}
