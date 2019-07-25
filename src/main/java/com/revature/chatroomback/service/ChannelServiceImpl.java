package com.revature.chatroomback.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.revature.chatroomback.dao.ChannelDAO;
import com.revature.chatroomback.models.Channel;

@Service
public class ChannelServiceImpl implements ChannelService {
	
	@Autowired
	private ChannelDAO channel;
	
	@Transactional
	public void registerChannel(Channel newChannel) {
		channel.save(newChannel);
	}

	@Transactional
	public List<Channel> list() {
		return channel.list();
	}
	@Transactional
	public List<Channel> listByUser(Channel obj) {
	      Integer channelUser1 = obj.getChannelUser1();
		return channel.listByUser(channelUser1);
	}
	
	@Transactional
	public List<Channel> listByType(String channelType) {
		return channel.listByType(channelType);
	}


	@Transactional
	public Channel getPrivateMessage(Channel obj) {
		return channel.getPrivateMessage(obj.getChannelUser1(), obj.getChannelUser2());
	}

	@Transactional
	public void update(Channel newChannel) {
		channel.save(newChannel);
	}

	@Transactional
	public void delete(Integer id) {
		channel.delete(id);
	}







}
