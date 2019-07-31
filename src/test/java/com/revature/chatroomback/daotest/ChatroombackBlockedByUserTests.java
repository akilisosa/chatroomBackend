package com.revature.chatroomback.daotest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.chatroomback.models.BlockedByUser;
import com.revature.chatroomback.models.Channel;
import com.revature.chatroomback.validator.ChatroomValidator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChatroombackBlockedByUserTests {
	@Autowired
	private ChatroomValidator chatroomCheck;

	BlockedByUser obj = new BlockedByUser();
	Channel channelObj = new Channel();
	
		@Test
		public void contextLoads() {
			
			obj.setBlockedUserId(1);
			obj.setBlockingUserId(2);
			assertFalse(chatroomCheck.doubleBlock(obj));
			
		}

	
}
