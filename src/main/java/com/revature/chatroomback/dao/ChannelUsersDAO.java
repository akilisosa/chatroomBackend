package com.revature.chatroomback.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.chatroomback.models.ChannelUsers;

@Repository
public interface ChannelUsersDAO extends JpaRepository<ChannelUsers,Integer>{

	@SuppressWarnings("unchecked")
	ChannelUsers save(ChannelUsers channelusers);

	@Query("select u from ChannelUsers u where u.channelUser = :channelUser")
	List<ChannelUsers> list();
	
	@Query("select u from ChannelUsers u where u.channelId =: channelId")
	List<ChannelUsers> properList(@Param("channelId") Integer channelId);

	@Query("select u from ChannelUsers u where u.channelUser = :channelUser")
	ChannelUsers findOne(@Param("channelUser") Integer channelUser);

	@Modifying
	@Query("delete from ChannelUsers where channelUser = :channelUser")
	void delete(@Param("channelUser") Integer channelUser); 
}