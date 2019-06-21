package com.cognizant.TaskManager.entitytest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.TaskManager.entity.ParentTask;


@RunWith(SpringJUnit4ClassRunner.class)
public class ParentTaskTest {
	
	@Test
	public void testParentTask() {
		ParentTask test = new ParentTask();
		test.setParentId(1l);
		assertEquals(1l,test.getParentId());
		test.setParentTask("parentTask");
		assertEquals("parentTask",test.getParentTask());
	}
}
