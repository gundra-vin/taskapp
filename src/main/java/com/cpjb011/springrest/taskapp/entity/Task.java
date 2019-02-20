package com.cpjb011.springrest.taskapp.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="Task")
public class Task {
	
	
	@Id
	@Column(name="Task_ID")
	private int tid;
	
	@Column(name="Parent_ID")
	private int pid;
	
	@Column(name="Task")
	private String task;
	
	@Column(name="Start_Date")
	private LocalDate sdate;
	
	@Column(name="End_Date")
	private LocalDate edate;
	
	@Column(name="Priority")
	private int priority;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Parent_ID", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Ptask ptask;
	
	public Ptask getPtask() {
		return ptask;
	}

	public void setPtask(Ptask ptask) {
		this.ptask = ptask;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public LocalDate getSdate() {
		return sdate;
	}

	public void setSdate(LocalDate sdate) {
		this.sdate = sdate;
	}

	public LocalDate getEdate() {
		return edate;
	}

	public void setEdate(LocalDate edate) {
		this.edate = edate;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	

}
