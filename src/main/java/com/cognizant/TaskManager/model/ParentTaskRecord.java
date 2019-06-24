package com.cognizant.TaskManager.model;

public class ParentTaskRecord {
	
	private long parentTaskId;
	
	private String parentTaskName;

	public String getParentTaskName() {
		return parentTaskName;
	}

	public void setParentTaskName(String parentTaskName) {
		this.parentTaskName = parentTaskName;
	}

	public long getParentTaskId() {
		return parentTaskId;
	}

	public void setParentTaskId(long parentTaskId) {
		this.parentTaskId = parentTaskId;
	}

	public ParentTaskRecord() {
		
	}	

}
