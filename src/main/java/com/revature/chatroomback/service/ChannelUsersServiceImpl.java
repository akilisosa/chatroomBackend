package com.revature.chatroomback.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.chatroomback.dao.ChannelUsersDAO;
import com.revature.chatroomback.models.ChannelUsers;

@Service
public class ChannelUsersServiceImpl implements ChannelUsersService{

	@Autowired
	private ChannelUsersDAO channelUsersDAO;
	
	@Transactional
	public void registerChannelUsers(ChannelUsers channelusers) {
		channelUsersDAO.save(channelusers);
	}

	@Transactional
	public List<ChannelUsers> list() {
		return channelUsersDAO.list();
	}
	
	@Transactional
	public List<ChannelUsers> properList(Integer channelId) {
		return channelUsersDAO.properList(channelId);
	}
	
	@Transactional
	public void delete(Integer id) {
		channelUsersDAO.delete(id);
	}

	@Transactional
	public void update(ChannelUsers channelusers) {
		channelUsersDAO.save(channelusers);
	}

	
	
}
