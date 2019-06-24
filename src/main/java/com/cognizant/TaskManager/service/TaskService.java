package com.cognizant.TaskManager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.TaskManager.entity.Task;
import com.cognizant.TaskManager.model.TaskRecord;
import com.cognizant.TaskManager.repo.TaskRepository;

@Service
@Transactional
public class TaskService {
	
	private static final Logger logger = Logger.getLogger(TaskService.class.getName());
	
	@Autowired
	TaskRepository repository;
	
	@Autowired
	ParentTaskService parentService;
	
	public TaskRecord addTask(TaskRecord taskRecord) {
		try {
			logger.info("saving data into data table");
			System.out.println("taskR>>" + taskRecord);
			Task task = new Task();
			task.setTaskName(taskRecord.getTaskName());
			task.setStartDate(taskRecord.getStartDate());
			task.setEndDate(taskRecord.getEndDate());
			task.setPriority(taskRecord.getPriority());
			task.setStatus(taskRecord.getStatus());
			task.setParentId(taskRecord.getParentId());
			repository.save(task);
			
			return taskRecord;
			
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occurred while saving all data into task table", e.getMessage());
			throw e;
		} 
	}
	
	public List<TaskRecord> getAllTasks() {
		try {
			logger.info("getting all data from data table");
			List<Task> tasks = new ArrayList<Task>();
			repository.findAll().forEach(tasks::add);
			List<TaskRecord> tlist = new ArrayList<TaskRecord>();
			for(Task t : tasks) {
				TaskRecord taskRecord = new TaskRecord();
				taskRecord.setTaskId(t.getTaskId());
				taskRecord.setTaskName(t.getTaskName());
				taskRecord.setStartDate(t.getStartDate());
				taskRecord.setEndDate(t.getEndDate());
				taskRecord.setPriority(t.getPriority());
				taskRecord.setStatus(t.getStatus());
				taskRecord.setParentId(t.getParentId());
				String parentTask = parentService.getparentTaskData(t.getParentId());
				taskRecord.setParentName(parentTask);
				tlist.add(taskRecord);
			}
			return tlist;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occured while getting all data from data table", e.getMessage());
			throw e;
		}
	}
	
	public Task updateTask(Long id, Task task) {
		
		try {
			logger.info("updating data in task table");
			task.setTaskId(id);
			return repository.save(task);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occurred while updating data into task table", e.getMessage());
			throw e;
		}
	}
	

	 public TaskRecord getTaskById(Long id) {
		 try {
			 logger.info("getting data from task table");
			 Optional<Task> task = repository.findById(id);
			 Task t = task.get();
			 TaskRecord taskRecord = new TaskRecord();
				taskRecord.setTaskId(t.getTaskId());
				taskRecord.setTaskName(t.getTaskName());
				taskRecord.setStartDate(t.getStartDate());
				taskRecord.setEndDate(t.getEndDate());
				taskRecord.setPriority(t.getPriority());
				taskRecord.setStatus(t.getStatus());
				taskRecord.setParentId(t.getParentId());
				String parentTask = parentService.getparentTaskData(t.getParentId());
				taskRecord.setParentName(parentTask);
				return taskRecord;
			 
		 } catch(Exception e) {
			 logger.log(Level.SEVERE, "Exception occurred while getting data from task table", e.getMessage());
			 throw e;
		 }
	 }

}
