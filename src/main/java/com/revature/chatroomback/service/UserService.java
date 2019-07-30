package com.revature.chatroomback.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.revature.chatroomback.models.User;

public interface UserService {
	
	void registerUser(User user) throws SQLIntegrityConstraintViolationException;

	List<User> list();
	
	User findOne(Integer id);

	User findByEmailAndPassword(String email, String password);
	
	void delete(Integer id);

	void update(User user);
	

}
