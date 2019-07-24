package com.revature.chatroomback.validator;



import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.chatroomback.models.BlockedByUser;
import com.revature.chatroomback.models.Channel;
import com.revature.chatroomback.service.BlockedByUserService;
import com.revature.chatroomback.service.ChannelService;



@Component //because its used by the main part. 
public class ChatroomValidator {
	
	
	Logger logger = LogManager.getLogger(ChatroomValidator.class);
	@Autowired
	private BlockedByUserService blockedByUserService;

	public boolean doubleBlock(BlockedByUser obj) {
		try {
			Integer service = blockedByUserService.findUserIdandBlockedId(obj);

			if (service == null) {
				logger.warn("the block feature is going fine");
				return true; 
			} 
			
		} catch (Exception e) {
			logger.info("there was a weird server error. you need to make a user defined one");
			return false;
		}
		return false;
	}
	
//	@Autowired
//	private ChannelService channelService;
//	public boolean multiplePM(Channel obj) {
//		try {
//			Channel service = channelService.getPM(obj);
//			
//			if (service == null)
//		}
//	}

}
