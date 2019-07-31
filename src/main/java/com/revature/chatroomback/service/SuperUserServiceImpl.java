package com.revature.chatroomback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.chatroomback.dao.UserDAO;
import com.revature.chatroomback.models.SuperUser;
import com.revature.chatroomback.models.User;
import com.revature.chatroomback.models.UserInfo;

@Service
public class SuperUserServiceImpl implements SuperUserService{

	@Autowired
	UserDAO userDao;

	@Override
	public void registerUser(User obj) {
		// TODO Auto-generated method stub
		
	}
	
//	@Transactional
//	public void registerUser(User obj) {
//	
//		
//		
//	}
//
//	
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

}
