package com.revature.chatroomback.controller;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.chatroomback.models.BlockedByUser;
import com.revature.chatroomback.models.SuperUser;
import com.revature.chatroomback.models.User;
import com.revature.chatroomback.models.UserInfo;
import com.revature.chatroomback.service.BlockedByUserService;
import com.revature.chatroomback.service.UserInfoService;
import com.revature.chatroomback.service.UserInfoServiceImpl;
import com.revature.chatroomback.service.UserService;


@RestController
@RequestMapping("User")
public class UserController {
	
Logger logger = LogManager.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private BlockedByUserService blockedByUserService;

	@PostMapping()
	public @ResponseBody ResponseEntity<SuperUser> register(@RequestBody User obj){
		logger.info("Registered a new User with email", obj.getEmail());
		try {
		userService.registerUser(obj);
		
		User user = userService.findByEmailAndPassword(obj.getEmail(), obj.getPassword());
		UserInfo newUserInfo = new UserInfo();
		newUserInfo.setId(user.getId());
		newUserInfo.setScreenName("annoymous"+user.getId());
		newUserInfo.setImage("your_link_here");
		userInfoService.registerUserInfo(newUserInfo);
		
		SuperUser superUser = new SuperUser();
		superUser.setAdminLvl(user.getAdminLvl());;
		superUser.setEmail(obj.getEmail());
		superUser.setImage(newUserInfo.getImage());
		superUser.setScreenName(newUserInfo.getScreenName());
		superUser.setUserId(user.getId());
		superUser.setPassword(obj.getPassword());
		superUser.setStatus(user.getStatus());
		
		return new ResponseEntity<SuperUser>(superUser, HttpStatus.CREATED);
		} catch (SQLException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);	
		}
		
	}

	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<HttpStatus> update(@PathVariable("id") Integer id,@RequestBody User user) {
		logger.info("UserController->update", id);
		userService.update(user);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@GetMapping()
	public @ResponseBody ResponseEntity<HttpStatus> list() {
		logger.error("somebody should not have been doing this");
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}

	@GetMapping("/{id}" )
	public User findOne(@PathVariable("id") Integer id) {
		return userService.findOne(id);
	}
	
	@PostMapping(value="/login/", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuperUser> findByEmailAndPassword(@RequestParam("email")String email,@RequestParam("password") String password) {
		User user = userService.findByEmailAndPassword(email, password);
		UserInfo userInfo = userInfoService.findOne(user.getId());
		List<BlockedByUser> blockedList = blockedByUserService.findBlocked(user.getId());
		
		SuperUser superUser = new SuperUser();
		superUser.setUserId(user.getId());
		superUser.setAdminLvl(user.getAdminLvl());
		superUser.setBirthYear(userInfo.getBirthYear());
		superUser.setEmail(email);
		superUser.setImage(userInfo.getImage());
		superUser.setPassword(password);
		superUser.setScreenName(userInfo.getScreenName());
		superUser.setStatus(user.getStatus());
		return new ResponseEntity<>(superUser, HttpStatus.OK);
		
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
		userService.delete(id);
		return new ResponseEntity<>(HttpStatus.GONE);
	}
	
	
}
