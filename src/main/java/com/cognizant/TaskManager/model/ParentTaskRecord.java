package com.cognizant.TaskManager.model;

public class ParentTaskRecord {
	
	private long id;
	
	private String parentTaskName;

	public String getParentTaskName() {
		return parentTaskName;
	}

	public void setParentTaskName(String parentTaskName) {
		this.parentTaskName = parentTaskName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ParentTaskRecord() {
		
	}

	public ParentTaskRecord(long id, String parentTaskName) {
		super();
		this.id = id;
		this.parentTaskName = parentTaskName;
	}
	
	

}
