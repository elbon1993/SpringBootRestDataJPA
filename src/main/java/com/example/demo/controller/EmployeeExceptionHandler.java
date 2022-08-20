package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.response.EmployeeResponse;

@ControllerAdvice
public class EmployeeExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<AbstractResponse> employeeExceptionHandler(Exception e) {
		AbstractResponse response = new EmployeeResponse();
		response.setIsSuccess(false);
		response.setDevMsg(e.getMessage());
		response.setErrorMsg("Something wrong happened, we on it");
		return new ResponseEntity<AbstractResponse>(response, HttpStatus.OK);
	}
	
//	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//	public ResponseEntity<AbstractResponse> methodNotSupported(Exception e) {
//		AbstractResponse response = new EmployeeResponse();
//		response.setIsSuccess(false);
//		response.setDevMsg(e.getMessage());
//		response.setErrorMsg("You are trying to access the method which is not supported");
//		return new ResponseEntity<AbstractResponse>(response, HttpStatus.OK);
//	}
}
