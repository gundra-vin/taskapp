package com.cpjb011.springrest.taskapp.testbean;

import java.time.LocalDate;

public class TaskInput {




	private int tid;
	private String task;
	private String ptask;
	private int priority;
	private String sdate;
	private String edate;

	public TaskInput(){}
	
	public TaskInput(int tid, String task, String ptask, int priority, String sdate, String edate) {
		super();
		this.tid = tid;
		this.task = task;
		this.ptask = ptask;
		this.priority = priority;
		this.sdate = sdate;
		this.edate = edate;
	}
	
	public int getTid() {
		return tid;
	}


	public void setTid(int tid) {
		this.tid = tid;
	}


	public String getTask() {
		return task;
	}


	public void setTask(String task) {
		this.task = task;
	}


	public String getPtask() {
		return ptask;
	}


	public void setPtask(String ptask) {
		this.ptask = ptask;
	}


	public int getPriority() {
		return priority;
	}


	public void setPriority(int priority) {
		this.priority = priority;
	}


	public String getSdate() {
		return sdate;
	}


	public void setSdate(String sdate) {
		this.sdate = sdate;
	}


	public String getEdate() {
		return edate;
	}


	public void setEdate(String edate) {
		this.edate = edate;
	}
	
}
