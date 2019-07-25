package com.revature.chatroomback.service;

import java.util.List;

import com.revature.chatroomback.models.Channel;



public interface ChannelService {

	void registerChannel(Channel channel);

	List<Channel> list();
	
	List<Channel> listByType(String type);
	
	List<Channel> listByUser(Channel obj);
	
	Channel getPrivateMessage(Channel obj);

	void update(Channel obj);
	
	void delete(Integer id);
}
