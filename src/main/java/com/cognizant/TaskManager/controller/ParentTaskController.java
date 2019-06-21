package com.cognizant.TaskManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.TaskManager.entity.ParentTask;
import com.cognizant.TaskManager.model.ParentTaskRecord;
import com.cognizant.TaskManager.service.ParentTaskService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/taskmanager/parentTasks")
public class ParentTaskController {
	
	
	@Autowired
	ParentTaskService parentService;
	
	@PostMapping(value = "/addTask")
	public ParentTaskRecord addParentTask (@RequestBody ParentTaskRecord parentTaskRecord) {
		return parentService.addParentTask(parentTaskRecord);
	}
	
	@GetMapping(value = "/getTasks")
	public List<ParentTask> getParentTasks() {
		return parentService.getParentTasks();
	}
	
	
}
