package com.cpjb011.springrest.taskapp.exceptions;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class TaskAppExceptionHandler {

	
	@ExceptionHandler(TaskNotFoundException.class)
	public ResponseEntity<ErrorStatus> taskExceptionHandler1
						(HttpServletRequest req, TaskNotFoundException e) 
	{
		
		ErrorStatus error = new ErrorStatus(new Date(), e.getMessage(),req.getRequestURI());
		return new ResponseEntity<ErrorStatus>(error, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorStatus> taskExceptionHandler2
                         (HttpServletRequest req, MethodArgumentNotValidException e)
                         {
		ErrorStatus error = new ErrorStatus(new Date(), e.getMessage(),req.getRequestURI());
		return new ResponseEntity<ErrorStatus>(error, HttpStatus.UNPROCESSABLE_ENTITY);
                         }
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorStatus> taskExceptionHandler
						(HttpServletRequest req, Exception e) 
	{
		
		ErrorStatus error = new ErrorStatus(new Date(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorStatus>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
