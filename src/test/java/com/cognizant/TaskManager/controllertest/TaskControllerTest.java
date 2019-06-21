package com.cognizant.TaskManager.controllertest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.TaskManager.controller.TaskController;
import com.cognizant.TaskManager.entity.Task;
import com.cognizant.TaskManager.model.TaskRecord;
import com.cognizant.TaskManager.service.TaskService;
import com.cognizant.TaskManager.utiltest.TaskMockData;



@RunWith(SpringJUnit4ClassRunner.class)
public class TaskControllerTest {

	@InjectMocks
	public TaskController taskController;

	@Mock
	public TaskService taskService;

	@Test
	public void addTaskTest() {
		Mockito.when(taskService.addTask(Mockito.any(TaskRecord.class)))
				.thenReturn(new TaskMockData().getTaskRecord());
		TaskRecord output = taskController.addTask(new TaskMockData().getTaskRecord());
		Assert.assertEquals(new TaskMockData().getTaskRecord().getTaskName(), output.getTaskName());
		Assert.assertEquals(new TaskMockData().getTaskRecord().getParentId(),
				output.getParentId());

	}

	@Test
	public void getAllTasksTest() {
		Mockito.when(taskService.getAllTasks()).thenReturn(new TaskMockData().getTaskRecordList());
		List<TaskRecord> output = taskController.getAllTasks();
		Assert.assertEquals(2, output.size());
	}

	@Test
	public void updateTaskTest() {

		Mockito.when(taskService.updateTask(Mockito.anyLong(), Mockito.any(Task.class)))
				.thenReturn(new TaskMockData().getSingleTask());
		Task output = taskController.updateTask((long) 1, new TaskMockData().getSingleTask());

		Assert.assertEquals(new TaskMockData().getSingleTask().getId(), output.getId());
	}

	@Test
	public void getTaskByIdTest() {
		Mockito.when(taskService.getTaskById(Mockito.anyLong()))
				.thenReturn(new TaskMockData().getTaskRecord());
		TaskRecord output = taskController.getTaskById(Mockito.anyLong());
		Assert.assertEquals(new TaskMockData().getTaskRecord().getTaskName(), output.getTaskName());
		Assert.assertEquals(new TaskMockData().getTaskRecord().getParentId(),
				output.getParentId());
	}
	
}

