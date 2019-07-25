package com.revature.chatroomback.service;

import java.util.List;

import com.revature.chatroomback.models.ChannelUsers;

public interface ChannelUsersService {
	void registerChannelUsers(ChannelUsers user);

	List<ChannelUsers> list();
	
	List<ChannelUsers> listFindMany();
	
	ChannelUsers findOne(Integer id);
	
	void delete(Integer id);

	void update(ChannelUsers user);
	
}
