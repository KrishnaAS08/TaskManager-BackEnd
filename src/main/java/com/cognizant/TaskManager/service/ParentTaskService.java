package com.cognizant.TaskManager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.TaskManager.entity.ParentTask;
import com.cognizant.TaskManager.model.ParentTaskRecord;
import com.cognizant.TaskManager.repo.ParentTaskRepository;

@Service
@Transactional
public class ParentTaskService {
	
private static final Logger logger = Logger.getLogger(ParentTaskService.class.getName());
	
	@Autowired
	ParentTaskRepository repository;
	
	public ParentTaskRecord addParentTask (ParentTaskRecord parentTaskRecord) {
		
		try {
			logger.info("adding data into parent task table");
			ParentTask parentTask = new ParentTask();
			parentTask.setParentTask(parentTaskRecord.getParentTaskName());
			repository.save(parentTask);
			
			return parentTaskRecord;
			
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occured while adding data into parent task table", e.getMessage());
			throw e;
		}
	}
	
	public List<ParentTask> getParentTasks() {
		
		try {
			logger.info("getting data from the parent task table");
			List<ParentTask> parentTasks = new ArrayList<ParentTask>();
			repository.findAll().forEach(parentTasks::add);
			
			return parentTasks;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occured while getting data from parent task table", e.getMessage());
			throw e;
		}
	}
	
	public String getparentTaskData(Long parentId) {
		String parentTaskName = repository.findNameById(parentId);
			return parentTaskName;
	}

}
