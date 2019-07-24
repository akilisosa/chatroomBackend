package com.revature.chatroomback.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.chatroomback.models.Channel;

public interface ChannelDAO extends JpaRepository<Channel,Integer>{

	@SuppressWarnings("unchecked")
	Channel save(Channel channel);

	@Query("select u from Channel u")
	List<Channel> list();
	
	@Query("select u from Channel u where u.channelId = :channelId")
	Channel findOne(@Param("channelId") Integer id);
	
	@Query("select u from Channel u where u.channelType = :channelType")
	List<Channel> listByType(@Param("channelType") Integer channelType);
	
	@Query("select u from channel u where u.channelUser1 = :channelUser1 AND u.channelUser2 =: channelUser2 OR u.channelUser1 =:channelUser2 AND u.channelUser2 =:channelUser1")
	Channel getPM(@Param("channelUser1") Integer channelUser1, @Param("channelUser2") Integer channelUser2 );
	
	@Modifying
	@Query("delete from Channel where u.channelId = :channelId")
	void delete(@Param("channelId") Integer id);

}
