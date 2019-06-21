package com.cognizant.TaskManager.controllertest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.TaskManager.controller.ParentTaskController;
import com.cognizant.TaskManager.entity.ParentTask;
import com.cognizant.TaskManager.model.ParentTaskRecord;
import com.cognizant.TaskManager.service.ParentTaskService;
import com.cognizant.TaskManager.utiltest.ParentTaskMockData;


@RunWith(SpringJUnit4ClassRunner.class)
public class ParentTaskControllerTest {
	
	@InjectMocks
    public ParentTaskController parentTaskController;
	
	@Mock
	public ParentTaskService parentTaskService;
	
	@Test
    public void addParentTaskTest(){

        Mockito.when(parentTaskService.addParentTask(Mockito.any(ParentTaskRecord.class)))
        .thenReturn(new ParentTaskMockData().getParentTaskRecord());
        ParentTaskRecord output = parentTaskController.addParentTask(new ParentTaskMockData().getParentTaskRecord());

        Assert.assertEquals(new ParentTaskMockData().getParentTaskRecord().getId(), output.getId());
        Assert.assertEquals(new ParentTaskMockData().getParentTaskRecord().getParentTaskName(), output.getParentTaskName());
    }

    @Test
    public void getParentTasksTest(){

        Mockito.when(parentTaskService.getParentTasks()).thenReturn(new ParentTaskMockData().getParentTaskList());
        List<ParentTask> output = parentTaskController.getParentTasks();

        Assert.assertEquals(2, output.size());
    }
}
