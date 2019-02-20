package com.cpjb011.springrest.taskapp;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.cpjb011.springrest.taskapp.bean.TaskIO;
import com.cpjb011.springrest.taskapp.controller.TaskController;
import com.cpjb011.springrest.taskapp.testbean.TaskInput;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TaskappApplicationIT {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	protected WebApplicationContext wac;

	@Autowired
	private TaskController taskController;

	@Before
	public void setUp() throws Exception {

	}

	
	@Test
	public void getallTasksTest() throws Exception {

		mockMvc.perform(get("/taskapp").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].tid", is(1))).andExpect(jsonPath("$[1].tid", is(2))).andDo(print());

	}

	
	@Test
	public void delTaskTest() throws Exception {
		mockMvc.perform(delete("/taskapp/{id}",3).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[2].tid", not(3))).andDo(print());
	}
	
	
	@Test
	public void delTaskNegativeTest() throws Exception {
		mockMvc.perform(delete("/taskapp/{id}",11).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound())
				.andDo(print());
	}
    
	
	@Test
	public void addTaskTest() throws Exception {

		TaskInput tio = getTaskInput1();

		mockMvc.perform(post("/taskapp").content(asJsonString(tio)).contentType(MediaType.APPLICATION_JSON))

				.andExpect(status().isOk());

	}
	
	
	@Test
	public void updTaskTest() throws Exception {

		TaskInput tio = getTaskInput2();

		mockMvc.perform(put("/taskapp").content(asJsonString(tio)).contentType(MediaType.APPLICATION_JSON))

				.andExpect(status().isOk());

	}
	
	
	@Test
	public void updTaskNegativeTest() throws Exception {

		TaskInput tio = getTaskInput2();
		tio.setTid(9999);

		mockMvc.perform(put("/taskapp").content(asJsonString(tio)).contentType(MediaType.APPLICATION_JSON))

				.andExpect(status().isNotFound());

	}
	
	static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public TaskIO getTaskIO1() {
		TaskIO tio = new TaskIO();
		tio.setTid(6);
		tio.setTask("Spring Boot Initializer and dummy run");
		tio.setPtask("Database Layer");
		tio.setPriority(6);
		LocalDate d1 = LocalDate.parse("2019-01-18", DateTimeFormatter.ISO_LOCAL_DATE);
		tio.setSdate(d1);
		LocalDate d2 = LocalDate.parse("2019-01-19", DateTimeFormatter.ISO_LOCAL_DATE);
		tio.setEdate(d2);
		return tio;
	}

	public TaskInput getTaskInput1() {
		TaskInput tio = new TaskInput();
		//tio.setTid(3);
		tio.setTask("Spring Boot Initializer and Intital run");
		tio.setPtask("Database Layer");
		tio.setPriority(6);

		tio.setSdate("2019-01-18");

		tio.setEdate("2019-01-19");
		return tio;
	}
	public TaskInput getTaskInput2() {
		TaskInput tio = new TaskInput();
		tio.setTid(3);
		tio.setTask("Spring Boot Initializer and Final run");
		tio.setPtask("Database Layer");
		tio.setPriority(6);

		tio.setSdate("2019-01-18");

		tio.setEdate("2019-01-22");
		return tio;
	}
}
