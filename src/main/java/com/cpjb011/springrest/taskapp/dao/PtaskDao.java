package com.cpjb011.springrest.taskapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cpjb011.springrest.taskapp.entity.Ptask;


public interface PtaskDao extends JpaRepository<Ptask, Integer> {
	
	public Ptask findByPtask(@Param("ptask") String ptask);
	
	@Query("SELECT max(pid) FROM Ptask")
	Integer getmaxPtaskId();

}
