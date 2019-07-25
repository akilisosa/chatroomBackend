package com.revature.chatroomback.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.chatroomback.models.ChannelUsers;

public interface ChannelUsersDAO extends JpaRepository<ChannelUsers,Integer>{

	@SuppressWarnings("unchecked")
	ChannelUsers save(ChannelUsers channelusers);

	@Query("select u from ChannelUsers u where u.channelUser = :channelUser")
	List<ChannelUsers> list();
	
	@Query("select u from ChannelUsers u where u.id = :userId")
	ChannelUsers findOne(@Param("userId") Integer id);

	@Modifying
	@Query("delete from ChannelUsers where id = :userId")
	void delete(@Param("userId") Integer id);
}