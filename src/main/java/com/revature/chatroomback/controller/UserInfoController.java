package com.revature.chatroomback.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.revature.chatroomback.models.UserInfo;
import com.revature.chatroomback.service.UserInfoService;

@RestController
@RequestMapping("UserInfo")
public class UserInfoController {
	
	Logger logger = LogManager.getLogger(UserInfoController.class);
	
	@Autowired
	private UserInfoService userInfoService;
	
	@PostMapping()
	public @ResponseBody void register(@RequestBody UserInfo obj){
		logger.info("UserInfoController->started new userInfo for user: ", obj.getId());
		userInfoService.registerUserInfo(obj);
	}	

	@PutMapping("/{id}")
	public @ResponseBody void update(@PathVariable("id") Integer id,@RequestBody UserInfo userInfo) {
		logger.info("UserController->update", id);
		userInfoService.update(userInfo);
	}
	
	@GetMapping()
	public ResponseEntity<List<UserInfo>> list() {
		logger.warn("UserInfoController-> someobody called the list user info that shouldn't happen");
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserInfo> findOne(@PathVariable("id") Integer id) {
		logger.info("UserInfo  found one!");
		return new ResponseEntity<>(userInfoService.findOne(id), HttpStatus.OK);
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
		logger.info("Somebody deleted somebody");
		userInfoService.delete(id);
		return new ResponseEntity<>(HttpStatus.GONE);
	}
}
