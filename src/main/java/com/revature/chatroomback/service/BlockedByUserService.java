package com.revature.chatroomback.service;

import java.util.List;

import com.revature.chatroomback.models.BlockedByUser;


public interface BlockedByUserService {

	void registerBlockedByUser(BlockedByUser obj);

	List<BlockedByUser> list();
	
	List<BlockedByUser> findBlocked(Integer id);
	
	Integer findUserIdandBlockedId(BlockedByUser obj);
	
	void delete(Integer id);

	void update(BlockedByUser obj);
	
	

}