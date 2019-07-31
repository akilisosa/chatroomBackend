package com.revature.chatroomback.daotest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.chatroomback.controller.BlockedByUserController;
import com.revature.chatroomback.dao.BlockedByUserDAO;
import com.revature.chatroomback.models.BlockedByUser;
import com.revature.chatroomback.service.BlockedByUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlockedByUserControllerTest {

	List<BlockedByUser> mockBlockedByUsers;
	BlockedByUser mockBlockedByUser;

@InjectMocks
BlockedByUserController blockedByUserController;

@Mock
private BlockedByUserDAO blockedByUserDao;

@Mock 
private BlockedByUserService blockedByUserService;

@Before
public void setUp() {
	MockitoAnnotations.initMocks(this);
	mockBlockedByUsers = getDummyBlockedByUsers();
	mockBlockedByUser = getDummyBlockedByUser();
	
	
}


@Test
public void testListBlock() {
	
	BlockedByUser block = new BlockedByUser(4,2,3);
	when(blockedByUserDao.save(block)).thenReturn(block);
	when(blockedByUserService.findBlocked(1)).thenReturn(mockBlockedByUsers);
    blockedByUserService.registerBlockedByUser(block);
    List<BlockedByUser> blocked  = blockedByUserService.findBlocked(1);
	assertEquals((Integer) 1, blocked);
	
	
}

	

private List<BlockedByUser> getDummyBlockedByUsers(){
	BlockedByUser b1 = new BlockedByUser(1, 1, 3);
	BlockedByUser b2 = new BlockedByUser(2, 1, 4);
	BlockedByUser b3 = new BlockedByUser(3, 1, 5);
	List<BlockedByUser> blockedByUser = new ArrayList<>();
	blockedByUser.add(b1);
	blockedByUser.add(b2);
	blockedByUser.add(b3);
	
	
	return mockBlockedByUsers;
	
}

private BlockedByUser getDummyBlockedByUser() {
	return new BlockedByUser(1,1,3);
}


	
}
