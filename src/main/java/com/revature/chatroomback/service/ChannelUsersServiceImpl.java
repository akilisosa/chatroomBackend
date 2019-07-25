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
	private ChannelUsersDAO ChannelUsersDAO;// = new channelChannelUserssDAO();
	
	@Transactional
	public void registerChannelUsers(ChannelUsers channelusers) {
		ChannelUsersDAO.save(channelusers);
	}

	@Transactional
	public List<ChannelUsers> list() {
		return ChannelUsersDAO.list();
	}
	
	@Transactional
	public ChannelUsers findOne(Integer id) {
		return ChannelUsersDAO.findOne(id);
	}
	
	@Transactional
	public void delete(Integer id) {
		ChannelUsersDAO.delete(id);
	}

	@Transactional
	public void update(ChannelUsers channelusers) {
		ChannelUsersDAO.save(channelusers);
	}

	@Override
	public List<ChannelUsers> listFindMany() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
