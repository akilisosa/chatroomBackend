package com.revature.chatroomback.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.chatroomback.dao.ChannelDAO;
import com.revature.chatroomback.models.Channel;

public class ChannelServiceImpl {
	@Autowired
	private ChannelDAO channel;
	
	@Transactional
	public void registerChannelUsers(Channel newChannel) {
		channel.save(newChannel);
	}

	@Transactional
	public List<Channel> list() {
		return channel.list();
	}
	
	@Transactional
	public Channel getPM(Channel newChannel) {
		Integer channelUser1 = newChannel.getChannelUser1();
		Integer channelUser2 = newChannel.getChannelUser2();
		return channel.getPM(channelUser1, channelUser2);
	}
	
	@Transactional
	public Channel findOne(Integer id) {
		return channel.findOne(id);
	}
	
	@Transactional
	public void delete(Integer id) {
	channel.delete(id);
	}

	@Transactional
	public void update(Channel newChannel) {
		channel.save(newChannel);
	}
}
