package com.cpjb011.springrest.taskapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cpjb011.springrest.taskapp.bean.TaskIO;
import com.cpjb011.springrest.taskapp.entity.Task;


public interface TaskDao extends JpaRepository<Task, Integer>{
	
	@Query("SELECT new com.cpjb011.springrest.taskapp.bean.TaskIO(t.tid,t.task,p.ptask,t.priority,t.sdate,t.edate)"
			+ "FROM Ptask p INNER JOIN p.tasks t")
	List<TaskIO> fetchTaskDetails();
	
	@Query("SELECT max(tid) FROM Task")
	Integer getmaxTaskId();
	
	

}
