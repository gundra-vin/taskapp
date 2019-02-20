package com.cpjb011.springrest.taskapp.controller;

import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpjb011.springrest.taskapp.bean.TaskIO;
import com.cpjb011.springrest.taskapp.service.TaskService;

@CrossOrigin
@RestController
@RequestMapping(value = "/taskapp")
public class TaskController {

@Autowired
private TaskService taskService;

@GetMapping
public List<TaskIO> getallTasks(){
	return taskService.allTaskDetails();
}

@PostMapping
public TaskIO addTask(@RequestBody @Valid TaskIO taskIO){
	return taskService.addTask(taskIO);
}

@PutMapping

public TaskIO updTask(@RequestBody TaskIO taskIO){
	return taskService.updTask(taskIO);
	 
}

@DeleteMapping("/{delid}")
public List<TaskIO> delTask(@PathVariable("delid") int delid){
	return taskService.delTask(delid);
}

}
