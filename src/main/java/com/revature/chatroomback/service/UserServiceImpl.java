package com.revature.chatroomback.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.chatroomback.dao.UserDAO;
import com.revature.chatroomback.models.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Transactional
	public void registerUser(User user) {
		userDAO.save(user);
	}

	@Transactional
	public List<User> list() {
		return userDAO.list();
	}
	
	@Transactional
	public User findOne(Integer id) {
		return userDAO.findOne(id);
	}
	
	@Transactional
	public void delete(Integer id) {
		userDAO.delete(id);
	}

	@Transactional
	public void update(User user) {
		userDAO.save(user);
	}

	@Transactional
	public User findByEmailAndPassword(String email, String password) {
		return userDAO.findByEmailAndPassword(email, password);
	}


}
