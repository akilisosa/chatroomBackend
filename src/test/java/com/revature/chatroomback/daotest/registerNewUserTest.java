package com.revature.chatroomback.daotest;

import static org.junit.Assert.assertNotNull;

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
		User user = userDao.save(newUser);
		assertNotNull(user);
	}
	
	@Test
	public void testResponse() {
		System.out.println("i hate you all");
		User user = userDao.findByEmailAndPassword("akilis@gmail.com", "akili");
		UserInfo newUserInfo = new UserInfo();
		newUserInfo.setId(user.getId());
		newUserInfo.setScreenName("annoymous"+user.getId());
		newUserInfo.setImage("your_link_here");
		userInfoDao.save(newUserInfo);
		UserInfo userInf = userInfoDao.findOne(user.getId());
		System.out.println("userInf");
		assertNotNull(userInf);
		
		
	}
	
}
//
//@PostMapping()
//public @ResponseBody ResponseEntity<SuperUser> register(@RequestBody User obj){
//	logger.info("Registered a new User with email", obj.getEmail());
//	try {
//	userService.registerUser(obj);
//	
//	User user = userService.findByEmailAndPassword(obj.getEmail(), obj.getPassword());
//	UserInfo newUserInfo = new UserInfo();
//	newUserInfo.setId(user.getId());
//	newUserInfo.setScreenName("annoymous"+user.getId());
//	newUserInfo.setImage("your_link_here");
//	userInfoService.registerUserInfo(newUserInfo);
//	
//	SuperUser superUser = new SuperUser();
//	superUser.setAdminLvl(user.getAdminLvl());;
//	superUser.setEmail(obj.getEmail());
//	superUser.setImage(newUserInfo.getImage());
//	superUser.setScreenName(newUserInfo.getScreenName());
//	superUser.setUserId(user.getId());
//	superUser.setPassword(obj.getPassword());
//	superUser.setStatus(user.getStatus());
//	
//	return new ResponseEntity<SuperUser>(superUser, HttpStatus.CREATED);
//	} catch (SQLException e) {
//		return new ResponseEntity<>(HttpStatus.CONFLICT);	
//	}
//	
//}
