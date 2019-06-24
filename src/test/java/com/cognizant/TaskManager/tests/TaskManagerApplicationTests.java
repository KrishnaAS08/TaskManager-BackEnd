package com.cognizant.TaskManager.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.TaskManager.TaskManagerApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskManagerApplicationTests {

	@Test
	public void contextLoads() {
		TaskManagerApplication.main(new String[] {});
	}

}