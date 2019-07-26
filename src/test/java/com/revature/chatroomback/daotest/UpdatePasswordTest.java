package com.revature.chatroomback.daotest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.chatroomback.dao.UserDAO;
import com.revature.chatroomback.models.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdatePasswordTest {
	
	@Autowired
	private UserDAO userDAO;
	
	User user = new User();
	
	@Test
	public void updatePassword() {
		user.setId(1);
		
		user.setPassword("pass123");
		
		userDAO.save(user);
		
		
	}
	

}
