package com.cognizant.TaskManager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parentTask")
public class ParentTask {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long parentId;
	
	@Column(name = "parent_Task")
	private String parentTaskName;

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public String getParentTask() {
		return parentTaskName;
	}

	public void setParentTask(String parentTaskName) {
		this.parentTaskName = parentTaskName;
	}

	public ParentTask(long parentId, String parentTaskName) {
		super();
		this.parentId = parentId;
		this.parentTaskName = parentTaskName;
	}

	public ParentTask() {
		
	}

	
	

}
