package com.cognizant.TaskManager.servicetest;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.cognizant.TaskManager.service.TaskService;



@RunWith(SpringJUnit4ClassRunner.class)
public class TaskServiceTest {
	
	@InjectMocks
	public TaskService taskService;
	


}
