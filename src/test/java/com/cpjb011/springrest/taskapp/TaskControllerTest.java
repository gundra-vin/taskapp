package com.cpjb011.springrest.taskapp;

import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.cpjb011.springrest.taskapp.bean.TaskIO;
import com.cpjb011.springrest.taskapp.controller.TaskController;
import com.cpjb011.springrest.taskapp.service.TaskService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TaskControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	protected WebApplicationContext wac;
	
	@Autowired
	private TaskController taskController;
	
	@MockBean
	private TaskService taskService;
	
	private List<TaskIO> taskdets = new ArrayList<TaskIO>();
	
	@Before
	public void setUp() throws Exception {
		//MockitoAnnotations.initMocks(this);
		TaskIO tio1 = getTaskIO1();
		TaskIO tio2 = getTaskIO2();
		this.taskdets.add(tio1);
		this.taskdets.add(tio2);
		
	}
	
	@Test
	public void getallTasksTest() throws Exception{
		
		when(taskService.allTaskDetails()).thenReturn(taskdets);
		mockMvc.perform(get("/taskapp")
		.contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
       .andExpect(jsonPath("$[0].tid", is(1)))
        .andExpect(jsonPath("$[1].tid", is(2)))
        .andDo(print());
		
	}
	
	
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

}
