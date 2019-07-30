package com.revature.chatroomback.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.chatroomback.models.User;
@Repository
public interface UserDAO extends JpaRepository<User,Integer>{
	
	@SuppressWarnings("unchecked")
	User save(User user);
	
	@Query("select u from User u")
	List<User> list();
	
	@Query("select u from User u where u.id = :id")
	User findOne(@Param("id") Integer id);
	
	@Query("select u from User u where u.email = :email and u.password = :password")
	User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

	@Modifying
	@Query("delete from User where id = :id")
	void delete(@Param("id") Integer id);

}
