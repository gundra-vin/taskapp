package com.cpjb011.springrest.taskapp.exceptions;

import java.util.Date;

public class ErrorStatus {
	
	private Date timestamp;
	  private String message;
	  private String details;
	  
	  public ErrorStatus(Date timestamp, String message, String details) {
	    super();
	    this.timestamp = timestamp;
	    this.message = message;
	    this.details = details;
	  }

}
