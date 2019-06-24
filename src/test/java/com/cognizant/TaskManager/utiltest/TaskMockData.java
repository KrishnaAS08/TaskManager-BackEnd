package com.cognizant.TaskManager.utiltest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cognizant.TaskManager.entity.Task;
import com.cognizant.TaskManager.model.TaskRecord;


public class TaskMockData {

	public TaskRecord getTaskRecord() {
		
		TaskRecord task=new TaskRecord();
		task.setTaskName("DummyTask");
		task.setStartDate(java.sql.Date.valueOf(LocalDate.parse("2019-04-02")));
		task.setEndDate(java.sql.Date.valueOf(LocalDate.parse("2019-04-03")));
		task.setPriority(1);
		task.setStatus("not-completed");
		task.setParentId(1L);
		task.setParentName("Task1");
		return task;
	}
	
	public Optional<Task> getSingleOptionalTask() {
		
		Task t = new Task((long) 1, "DummyTask", java.sql.Date.valueOf(LocalDate.parse("2019-04-02")),
				java.sql.Date.valueOf(LocalDate.parse("2019-04-03")), 1, (long) 1,"not-completed");
		

		return Optional.of(t);
	}
	
	public Task  getSingleTask() {

		return new Task((long) 1, "DummyTask", java.sql.Date.valueOf(LocalDate.parse("2019-04-02")),
				java.sql.Date.valueOf(LocalDate.parse("2019-04-03")), 1, (long) 1,"not-completed");
	}

	public List<TaskRecord> getTaskRecordList() {

		List<TaskRecord> taskList = new ArrayList<>();

		taskList.add(new TaskRecord((long) 1, "DummyTask", java.sql.Date.valueOf(LocalDate.parse("2019-04-02")),
				java.sql.Date.valueOf(LocalDate.parse("2019-04-03")), 1, "not-completed", "parentName1", (long) 1));

		taskList.add(new TaskRecord((long) 2, "DummyTask2", java.sql.Date.valueOf(LocalDate.parse("2019-05-03")),
				java.sql.Date.valueOf(LocalDate.parse("2019-05-06")), 1, "not-completed", "parentName2", (long) 2));

		return taskList;
	}
	
	public List<Task> getTaskList() {

		List<Task> taskList = new ArrayList<>();

		taskList.add(new Task((long) 1, "DummyTask",
				java.sql.Date.valueOf(LocalDate.parse("2019-04-02")),
				java.sql.Date.valueOf(LocalDate.parse("2019-04-03")), 1, (long) 1,"not-completed"));
		
		taskList.add(new Task((long) 2, "DummyTask2",
				java.sql.Date.valueOf(LocalDate.parse("2019-05-05")),
				java.sql.Date.valueOf(LocalDate.parse("2019-05-09")), 2, (long) 2,"not-completed"));



		return taskList;
	}



}
