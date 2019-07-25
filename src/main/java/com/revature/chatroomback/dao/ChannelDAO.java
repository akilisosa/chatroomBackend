package com.revature.chatroomback.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.chatroomback.models.Channel;

@Repository
public interface ChannelDAO extends JpaRepository<Channel,Integer>{

	@SuppressWarnings("unchecked")
	Channel save(Channel newChannel);

	@Query("select u from Channel u")
	List<Channel> list();
	
	@Query("select u from Channel u where u.channelType = :channelType")
	List<Channel> listByType(@Param("channelType") String channelType);
	
	@Query("select u from Channel u where u.channelUser1 = :channelUser1 or u.channelUser2 =: channelUser1")
	List<Channel> listByUser(@Param("channelUser1") Integer channelUser1);
	
	@Query("select u from Channel u where u.channelUser1 =: user1 AND u.channelUser2 =: user2 OR u.channelUser1 =: user2 AND u.channelUser2 =: channelUser1 ")
	Channel getPrivateMessage(Integer user1, Integer user2);
	
	
	@Modifying
	@Query("delete from Channel where id = :id")
	void delete(@Param("id") Integer id);


}
