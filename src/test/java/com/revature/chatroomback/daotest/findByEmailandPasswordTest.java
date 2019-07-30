package com.revature.chatroomback.daotest;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import com.revature.chatroomback.dao.UserDAO;
import com.revature.chatroomback.dao.UserInfoDAO;
import com.revature.chatroomback.models.User;
import com.revature.chatroomback.models.UserInfo;
import com.revature.chatroomback.service.UserInfoService;
import com.revature.chatroomback.service.UserService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class findByEmailandPasswordTest {

	@Autowired
	private UserDAO userDao;
	
	User user = new User();
	
	@Test
	public void testUserDao() {
		user.setPassword("akili");
		user.setEmail("akili@gmail.com");
		User user = userDao.findByEmailAndPassword("akili@gmail.com", "akili");
		assertNotNull(user);
	}
	
	@Test
	public void testWrongUserDao() {
		user.setPassword("akilis");
		user.setEmail("akili@gmail.com");
		User user = userDao.findByEmailAndPassword("akili@gmail.com", "akili");
		assertNotNull(user);
	}
	
	@Autowired
	UserService userService;
	@Test
	public void testUserService() {
		User me = userService.findByEmailAndPassword("akili@gmail.com", "akili");
		assertNotNull(me);
	}
	
	@Test
	public void testWrongPassword() {
		User her = userService.findByEmailAndPassword("akili@gmail.com", "password");
		assertNull(her);
	}
	

	@Autowired
	UserInfoDAO userInfoDao;
	
	@Autowired
	UserInfoService userInfo;
	
	@Test
	public void testDaoFindOne() {
	System.out.println("this is the dao test");
	UserInfo info = userInfoDao.findOne(1);
	System.out.println(info);
	assertNotNull(info);
	}
	
	@Test
	public void testUserInfo() {
		System.out.println("this is userinfo test");
		UserInfo info = userInfo.findOne(1);
		System.out.println(info);
		assertNotNull(info);
		
	}
	
	

	
}

