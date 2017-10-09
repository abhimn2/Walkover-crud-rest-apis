package com.walkover.restapi.model;

import org.springframework.http.HttpStatus;

/**
 * Bean class for Status codes
 * @author Abhishek Soni
 */
public class Status {

	private HttpStatus code;
	private String message;


	public Status(HttpStatus code, String message) {
		this.code = code;
		this.message = message;
	}

	public HttpStatus getCode() {
		return code;
	}

	public void setCode(HttpStatus code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
