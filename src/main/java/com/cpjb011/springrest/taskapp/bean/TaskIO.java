package com.cpjb011.springrest.taskapp.bean;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

public class TaskIO {

	private int tid;
	@NotBlank(message="Task shouldn't be blank")
	private String task;
	@NotBlank(message="Parent Task shouldn't be blank")
	private String ptask;
	private int priority;
	private LocalDate sdate;
	private LocalDate edate;

	public TaskIO() {

	}

	public TaskIO(int tid, String task, String ptask, int priority, LocalDate sdate, LocalDate edate) {
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

	@Override
	public String toString() {
		return "TaskIO [tid=" + tid + ", task=" + task + ", ptask=" + ptask + ", priority=" + priority + ", sdate="
				+ sdate + ", edate=" + edate + "]";
	}

}
