package com.revature.chatroomback.validator;



import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.chatroomback.models.BlockedByUser;
import com.revature.chatroomback.models.Channel;
import com.revature.chatroomback.models.User;
import com.revature.chatroomback.service.BlockedByUserService;
import com.revature.chatroomback.service.ChannelService;
import com.revature.chatroomback.service.UserService;




@Component //because its used by the main part. 
public class ChatroomValidator {
	
	
	Logger logger = LogManager.getLogger(ChatroomValidator.class);
	
	@Autowired
	private BlockedByUserService blockedByUserService;

	public boolean doubleBlock(BlockedByUser obj) {
		try {
			Integer service = blockedByUserService.findUserIdandBlockedId(obj);
			if (service == null) {
				logger.info("the block feature is going fine");
				return false; 
			} else {
				return true;
			}
			
		} catch (Exception e) {
			logger.info("there was a weird server error. you need to make a user defined one");
			return true;
		}
	
	}
	
	@Autowired
	private ChannelService channelService;
	
	public boolean multiplePM(Channel obj) {
		try {
			Channel chan = channelService.getPrivateMessage(obj);
			
			if (chan == null) {
				logger.info("the pm service is going fine");
				return false;
			}
		} catch (Exception e) {
			logger.fatal("something is really not going write with the channel service multiplePM");
			return true;
		}
		return true;
	}
	
//	@Autowired
//	private UserService userService;
//	public boolean alreadyRegisterd(User user) {
//		User user = userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
//		
//	}
	
	

}
