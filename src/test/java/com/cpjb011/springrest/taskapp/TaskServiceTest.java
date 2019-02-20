package com.cpjb011.springrest.taskapp;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cpjb011.springrest.taskapp.bean.TaskIO;
import com.cpjb011.springrest.taskapp.dao.PtaskDao;
import com.cpjb011.springrest.taskapp.dao.TaskDao;
import com.cpjb011.springrest.taskapp.entity.Task;
import com.cpjb011.springrest.taskapp.service.TaskService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskServiceTest {
	
	@MockBean
	private PtaskDao ptaskDao;
	
	@MockBean
	private TaskDao taskDao;
	
	@Autowired
	private TaskService taskService;
	
	@Before
	public void setUp() throws Exception {
		//MockitoAnnotations.initMocks(this);
		
	}
	
/*	@Test
	public void TestaddTask(){
		when(taskDao.saveAndFlush(any(Task.class))).thenReturn(new Task());
		assertThat(taskService.addTask(getTaskIO()), is(notNullValue()));
	}*/
	
	
	@Test
	public void TestfetchallTasks(){
		List<TaskIO> tlst = new ArrayList<TaskIO>();
		tlst.add(getTaskIO1());
		tlst.add(getTaskIO2());
		when(taskDao.fetchTaskDetails()).thenReturn(tlst);
		assertThat(taskService.allTaskDetails(), hasSize(2));
	}
	
/*	@Test
	public void TestUpdateTask(){
		TaskIO tio = getTaskIO1();
		Task tsk = getTask1();
		when(taskDao.saveAndFlush(tsk)).thenReturn(tsk);
		assertThat(taskService.updTask(tio), is(notNullValue()));
	}*/
	

	public TaskIO getTaskIO1(){
		TaskIO tio = new TaskIO();
		tio.setTid(1);
		tio.setTask("UI build pages");
		tio.setPtask("UI Build");
		tio.setPriority(6);
		LocalDate d1 = LocalDate.parse("2019-01-18", DateTimeFormatter.ISO_LOCAL_DATE);
		tio.setSdate(d1);
		LocalDate d2 = LocalDate.parse("2019-01-19", DateTimeFormatter.ISO_LOCAL_DATE);
        tio.setEdate(d2);
		return tio;
	}
	public TaskIO getTaskIO2(){
		TaskIO tio = new TaskIO();
		tio.setTid(2);
		tio.setTask("UI Jasmine Tests");
		tio.setPtask("UI Build");
		tio.setPriority(6);
		LocalDate d1 = LocalDate.parse("2019-01-18", DateTimeFormatter.ISO_LOCAL_DATE);
		tio.setSdate(d1);
		LocalDate d2 = LocalDate.parse("2019-01-19", DateTimeFormatter.ISO_LOCAL_DATE);
        tio.setEdate(d2);
		return tio;
	}
	
	public Task getTask1(){
		
		Task t1 = new Task();
		t1.setTid(1);
		t1.setPid(1);
		t1.setTask("UI Build Pages");
		t1.setPriority(6);
		LocalDate d1 = LocalDate.parse("2019-01-18", DateTimeFormatter.ISO_LOCAL_DATE);
		t1.setSdate(d1);
		LocalDate d2 = LocalDate.parse("2019-01-19", DateTimeFormatter.ISO_LOCAL_DATE);
		t1.setEdate(d2);
		return t1;
		
	}

}
