package com.revature.chatroomback.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.chatroomback.models.UserInfo;

@Repository
public  interface UserInfoDAO extends JpaRepository<UserInfo,Integer>{

	
	@SuppressWarnings("unchecked")
	UserInfo save(UserInfo user);
	
	@Query("select u from UserInfo u")
	List<UserInfo> list();
	
	@Query("select u from UserInfo u where u.id = :id")
	UserInfo findOne(@Param("id") Integer id);

	@Modifying
	@Query("delete from UserInfo where id = :id")
	void delete(@Param("id") Integer id);
	
}
