package com.cognizant.TaskManager.modeltest;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.TaskManager.model.TaskRecord;



@RunWith(SpringJUnit4ClassRunner.class)
public class TaskRecordTest {
	
	@Test
	public void testTaskRecord(){
		TaskRecord test = new TaskRecord();
		String taskName = "taskName";
		test.setTaskName(taskName);
		assertEquals("taskName", test.getTaskName());
		Date startDate = new Date();
		test.setStartDate(startDate);
		assertEquals(startDate, test.getStartDate());
		Date endDate = new Date();
		test.setEndDate(endDate);
		assertEquals(endDate, test.getEndDate());
		test.setPriority(1);
		assertEquals(1, test.getPriority());
		test.setStatus("not-completed");
		assertEquals("not-completed", test.getStatus());
		test.setParentName("parentName");
		assertEquals("parentName", test.getParentName());
		test.setParentId(1l);
		assertEquals(1l,test.getParentId());
	}
}
