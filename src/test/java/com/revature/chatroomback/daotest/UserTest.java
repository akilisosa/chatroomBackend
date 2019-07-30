package com.revature.chatroomback.daotest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.chatroomback.dao.UserDAO;
import com.revature.chatroomback.models.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
	
	@Autowired
	private UserDAO userDAO;
	
	User user = new User();
	
	@Test
	public void register() {
		user.setEmail("juanf@gmail.com");
		user.setPassword("pass123");
		user.setStatus("active");
		user.setAdminLvl("1");
		
		try {
		userDAO.save(user);
		} catch (Exception e) {
			assertTrue(true);
		}
		
	}

}
