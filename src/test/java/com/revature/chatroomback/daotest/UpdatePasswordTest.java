package com.revature.chatroomback.daotest;

import static org.junit.Assert.assertNotNull;

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
		user.setEmail("akili@gmail.com");
		user.setPassword("pass123");
		user.setStatus("1");
		user.setAdminLvl("2");
		
		assertNotNull(userDAO.save(user));
		
		
	}
	

}
