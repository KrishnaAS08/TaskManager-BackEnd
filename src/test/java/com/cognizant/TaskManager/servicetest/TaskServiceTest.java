package com.cognizant.TaskManager.servicetest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.TaskManager.entity.Task;
import com.cognizant.TaskManager.model.TaskRecord;
import com.cognizant.TaskManager.repo.TaskRepository;
import com.cognizant.TaskManager.service.ParentTaskService;
import com.cognizant.TaskManager.service.TaskService;
import com.cognizant.TaskManager.utiltest.TaskMockData;




@RunWith(SpringJUnit4ClassRunner.class)
public class TaskServiceTest {
	
	@InjectMocks
	public TaskService taskService;
	
	@Mock
	public TaskRepository taskRepository;
	
	@Mock
	public ParentTaskService parentTaskService;
	
	@Test
	public void addTaskTest() {
		Mockito.when(taskRepository.save(Mockito.any(Task.class)))
				.thenReturn(new TaskMockData().getSingleTask());
		TaskRecord output = taskService.addTask(new TaskMockData().getTaskRecord());
		Assert.assertEquals(new TaskMockData().getTaskRecord().getTaskName(), output.getTaskName());
		Assert.assertEquals(new TaskMockData().getTaskRecord().getParentId(),
				output.getParentId());

	}

	@Test
	public void getAllTasksTest() {
		Mockito.when(taskRepository.findAll()).thenReturn(new TaskMockData().getTaskList());
		List<TaskRecord> output = taskService.getAllTasks();

		Assert.assertEquals(2, output.size());
	}

	@Test
	public void updateTaskTest() {

		Mockito.when(taskRepository.save(Mockito.any(Task.class)))
		.thenReturn(new TaskMockData().getSingleTask());
		Task output = taskService.updateTask((long) 1, new TaskMockData().getSingleTask());
		Assert.assertEquals(new TaskMockData().getSingleTask().getTaskId(), output.getTaskId());
	}

	@Test
	public void getTaskByIdTest() {
		Mockito.when(taskRepository.findById(Mockito.anyLong()))
				.thenReturn(new TaskMockData().getSingleOptionalTask());
		TaskRecord output = taskService.getTaskById(Mockito.anyLong());
		Assert.assertEquals(new TaskMockData().getTaskRecord().getTaskName(), output.getTaskName());
		Assert.assertEquals(new TaskMockData().getTaskRecord().getParentId(),
				output.getParentId());
	}
	
	@Test(expected = RuntimeException.class)
	public void saveTaskNavigativeScenario() {
		Mockito.when(taskRepository.save(Mockito.any(Task.class))).thenThrow(RuntimeException.class);

		TaskRecord output = taskService.addTask(new TaskMockData().getTaskRecord());

		Assert.assertEquals(new TaskMockData().getTaskRecord().getTaskName(), output.getTaskName());
	}

	@Test(expected = RuntimeException.class)
	public void updateTaskTestNavigativeScenario() {
		Mockito.when(taskRepository.save(Mockito.any(Task.class))).thenThrow(RuntimeException.class);
		Task output = taskService.updateTask((long) 1, new TaskMockData().getSingleTask());

		Assert.assertEquals(new TaskMockData().getSingleTask().getTaskId(), output.getTaskId());
	}

	@Test(expected = RuntimeException.class)
	public void getTaskTestNavigativeScenario() {
		Mockito.when(taskRepository.findAll()).thenThrow(RuntimeException.class);

		List<TaskRecord> output = taskService.getAllTasks();

		Assert.assertEquals(2, output.size());
	}

	@Test(expected = RuntimeException.class)
	public void getTaskByIdTestNavigativeScenario() {
		Mockito.when(taskRepository.findById(Mockito.anyLong())).thenThrow(RuntimeException.class);

		TaskRecord output = taskService.getTaskById(Mockito.anyLong());

		Assert.assertEquals(new TaskMockData().getTaskRecord().getTaskName(), output.getTaskName());
	}

}
