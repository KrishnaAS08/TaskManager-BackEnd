package com.cognizant.TaskManager.model;

import java.util.Date;


public class TaskRecord {
	
	private long id;	
	private String taskName;	
	private Date startDate;	
	private Date endDate;	
	private int priority;
	private String status;
	private String parentName;
	private long parentId;

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TaskRecord() {

	}

	public TaskRecord(long id, String taskName, Date startDate, Date endDate, int priority, String status,
			long parentId) {
		super();
		this.id = id;
		this.taskName = taskName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.status = status;
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "TaskRecord [taskId=" + id + ", taskName=" + taskName + ", startDate=" + startDate + ", endDate="
				+ endDate + ", priority=" + priority + ", status=" + status + ", parentTaskId=" + parentId + "]";
	}
	
	
}