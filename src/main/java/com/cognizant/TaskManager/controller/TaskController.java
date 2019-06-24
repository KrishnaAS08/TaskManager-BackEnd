package com.cognizant.TaskManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.TaskManager.entity.Task;
import com.cognizant.TaskManager.model.TaskRecord;
import com.cognizant.TaskManager.repo.TaskRepository;
import com.cognizant.TaskManager.service.TaskService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/taskmanager/tasks")
public class TaskController {
	
	@Autowired
	TaskRepository repository;
	
	@Autowired
	TaskService taskService;
	
	@PostMapping(value = "/addTask")
	public TaskRecord addTask(@RequestBody TaskRecord taskRecord) {
		return taskService.addTask(taskRecord);	
	}
	
	@GetMapping(value = "/getTasks")
	public List<TaskRecord> getAllTasks() {
		return taskService.getAllTasks();		
	}
	
	@PutMapping(value = "/updateTask/{taskId}")
	public Task updateTask(@PathVariable("taskId") Long id, @RequestBody Task task) {
		return taskService.updateTask(id, task);		
	}
	
	@GetMapping(value = "/getTask/{taskId}")
	public TaskRecord getTaskById(@PathVariable("taskId") Long id) {
		return taskService.getTaskById(id);
	}
	
	

}
