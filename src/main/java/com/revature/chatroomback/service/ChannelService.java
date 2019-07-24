package com.revature.chatroomback.service;

import java.util.List;

import com.revature.chatroomback.models.Channel;



public interface ChannelService {

	void registerChannel(Channel channel);

	List<Channel> list();
	
	Channel findOne(Integer id);
	
	List<Channel> listByType(Integer type);
	
	Channel getPM(Channel channel);
	
	void delete(Integer id);

	void update(Channel channel);
}
