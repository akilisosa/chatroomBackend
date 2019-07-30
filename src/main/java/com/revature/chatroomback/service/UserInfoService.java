package com.revature.chatroomback.service;

import java.util.List;

import com.revature.chatroomback.models.UserInfo;

public interface UserInfoService {

	void registerUserInfo(UserInfo obj);

	List<UserInfo> list();
	
	UserInfo findOne(Integer id);
	
	void delete(Integer id);

	void update(UserInfo userinfo);

}