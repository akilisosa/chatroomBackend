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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.chatroomback.models.BlockedByUser;
import com.revature.chatroomback.service.BlockedByUserService;
import com.revature.chatroomback.validator.ChatroomValidator;




@RestController //or @Controller
@RequestMapping("BlockedByUser")
public class BlockedByUserController {

	Logger logger = LogManager.getLogger(BlockedByUserController.class);
	
	@Autowired
	private BlockedByUserService blockedByUserService;
	
	@Autowired
	private ChatroomValidator chatroomCheck;
	
	

	@PostMapping()
	public @ResponseBody ResponseEntity<HttpStatus> register(@RequestBody BlockedByUser obj) {
		int userId = obj.getBlockingUserId();
		int blockedId = obj.getBlockedUserId();
		
		String msg = " user: "+ userId + " blocked " + blockedId;
		String error = " user: "+ userId + " blocked " + blockedId + "already exists";
		
		try {
			
			 if (chatroomCheck.doubleBlock(obj)) {
				logger.info(error);
				 return new ResponseEntity<HttpStatus>(HttpStatus.CONFLICT);
			}else {
				blockedByUserService.registerBlockedByUser(obj);
				logger.info(msg);
				return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
			}
				
		} catch (Exception e) {
			logger.fatal(error+"caused by some other error");
			return new ResponseEntity<HttpStatus>(HttpStatus.FORBIDDEN);
		}
	}

	
	
	@GetMapping()
	public List<BlockedByUser> list() {
		return blockedByUserService.list();
	}

	@GetMapping("/{id}")
	public List<BlockedByUser> findBlocked(@PathVariable("id") Integer id) {
		return blockedByUserService.findBlocked(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		String msg = " somebody forgave someone";
		logger.info(msg);
		blockedByUserService.delete(id);
	}
	
}
