package com.cpjb011.springrest.taskapp.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Parent_Task")
public class Ptask {
	
	
	@Id
	@Column(name = "Parent_ID")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int pid;



	@Column(name = "Parent_Task")
	private String ptask;
	
	@OneToMany(targetEntity=Task.class, mappedBy ="pid", orphanRemoval=false, fetch=FetchType.LAZY)
	private Set<Task> tasks;
	

	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public String getPtask() {
		return ptask;
	}


	public void setPtask(String ptask) {
		this.ptask = ptask;
	}

	public Set<Task> getTasks() {
		return tasks;
	}


	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
	
}
