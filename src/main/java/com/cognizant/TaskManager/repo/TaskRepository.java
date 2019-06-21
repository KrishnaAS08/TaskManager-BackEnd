package com.cognizant.TaskManager.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.TaskManager.entity.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
	
}
