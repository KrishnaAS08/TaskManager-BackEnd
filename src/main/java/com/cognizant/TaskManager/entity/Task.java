package com.cognizant.TaskManager.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "task")
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name = "task")
	private String taskName;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "start_Date")
	private Date startDate;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "end_Date")
	private Date endDate;
	
	@Column(name = "priority")
	private int priority;
	
	@Column(name = "parent_Id")
	private long parentId;
	
	@Column(name="status")
	private String status;

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
	
	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Task(long id, String taskName, Date startDate, Date endDate, int priority, long parentId, String status) {
		super();
		this.id = id;
		this.taskName = taskName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.parentId = parentId;
		this.status = status;
	}

	public Task() {
		
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", taskName=" + taskName + ", startDate=" + startDate + ", endDate=" + endDate + ", priority="
				+ priority + ", parentId=" + parentId + "]";
	}
	
	
	

}
