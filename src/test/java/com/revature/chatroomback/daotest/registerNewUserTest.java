package com.revature.chatroomback.daotest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.chatroomback.dao.UserDAO;
import com.revature.chatroomback.dao.UserInfoDAO;
import com.revature.chatroomback.models.SuperUser;
import com.revature.chatroomback.models.User;
import com.revature.chatroomback.models.UserInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class registerNewUserTest {

	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private UserInfoDAO userInfoDao;
	
	User user = new User();
	
	@Test
	public void testRegitser() {
		User newUser = new User();
		newUser.setAdminLvl("1");
		newUser.setEmail("akilis@gmail.com");
		newUser.setPassword("akili");
		newUser.setStatus("active");
		try {
		userDao.save(newUser);
		} catch (Exception e) {
		assertTrue(true);
		}
	}
	
	@Test
	public void testResponse() {
		User user = userDao.findByEmailAndPassword("akilis@gmail.com", "akili");
		UserInfo newUserInfo = new UserInfo();
		newUserInfo.setId(user.getId());
		newUserInfo.setScreenName("annoymous"+user.getId());
		newUserInfo.setImage("your_link_here");
		userInfoDao.save(newUserInfo);
		UserInfo userInf = userInfoDao.findOne(user.getId());
		assertNotNull(userInf);	
	}	
	
}
