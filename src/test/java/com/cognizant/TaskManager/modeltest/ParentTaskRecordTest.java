package com.cognizant.TaskManager.modeltest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.TaskManager.model.ParentTaskRecord;


@RunWith(SpringJUnit4ClassRunner.class)
public class ParentTaskRecordTest {
	
	@Test
	public void testParentTaskRecord() {
		ParentTaskRecord test = new ParentTaskRecord();
		test.setParentTaskId(1l);
		assertEquals(1l,test.getParentTaskId());
		test.setParentTaskName("parentTask");
		assertEquals("parentTask",test.getParentTaskName());
	}
	
}
