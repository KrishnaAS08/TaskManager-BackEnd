package com.cognizant.TaskManager.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.TaskManager.entity.ParentTask;

@Repository
public interface ParentTaskRepository extends CrudRepository<ParentTask, Long> {
	
	@Query("select a.parentTaskName from ParentTask a where a.parentId=:parentId")
	String findNameById(@Param("parentId") Long parentId);
}
