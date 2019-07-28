package com.revature.chatroomback.service;

import java.util.List;

import com.revature.chatroomback.models.BlockedByUser;


public interface BlockedByUserService {

	void registerBlockedByUser(BlockedByUser obj);
	
	List<BlockedByUser> findBlocked(Integer blockingUser);
	
	Integer findUserIdandBlockedId(BlockedByUser obj);
	
	void delete(Integer BlockedId);
	

}