package com.revature.chatroomback.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.chatroomback.dao.BlockedByUserDAO;
import com.revature.chatroomback.models.BlockedByUser;
import com.revature.chatroomback.service.BlockedByUserService;

@Service //this one has the service
public class BlockedByUserServiceImpl implements BlockedByUserService {

	@Autowired
	private BlockedByUserDAO blockedByUserDAO;// = new UserDAO();
	
	@Transactional
	public void registerBlockedByUser(BlockedByUser blockedByUser) {
		blockedByUserDAO.save(blockedByUser);
	}

	@Transactional
	public Integer findUserIdandBlockedId(BlockedByUser obj) {
		//add the validation here
		int blockingUserId = obj.getBlockingUserId();
		int blockedUserId = obj.getBlockedUserId();
		return blockedByUserDAO.findifBlocked(blockingUserId, blockedUserId);
		
	}
	
	@Transactional
	public List<BlockedByUser> list() {
		return blockedByUserDAO.list();
	}
	
	@Transactional
	public List<BlockedByUser> findBlocked(Integer id) {
		return blockedByUserDAO.findBlocked(id);
	}
	
	@Transactional
	public void delete(Integer id) {
		blockedByUserDAO.delete(id);
	}

	@Override
	public void update(BlockedByUser blockedByUser) {
		blockedByUserDAO.save(blockedByUser);
	}

	
}