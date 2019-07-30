package com.revature.chatroomback.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.chatroomback.models.BlockedByUser;

@Repository //this is for anything to talks the database
public interface BlockedByUserDAO extends JpaRepository<BlockedByUser,Integer>{

	@SuppressWarnings("unchecked")
	BlockedByUser save(BlockedByUser obj);

	@Query("select u from BlockedByUser u where u.blockingUserId = :blockingUserId")
	List<BlockedByUser> findBlocked(@Param("blockingUserId") Integer id);

	@Query("select u from BlockedByUser u where u.blockingUserId = :blockingUserId and u.blockedUserId = :blockedUserId")
	Integer findifBlocked(@Param("blockingUserId") Integer blockingUserId, @Param("blockedUserId") Integer blockedUserId);
	
	@Modifying
	@Query("delete from BlockedByUser where id = :id")
	void delete(@Param("id") Integer id);
	
	
}
