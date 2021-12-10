package com.exception;

import com.model.Employee;

public class DuplicateEmployeeException extends Exception{

	public DuplicateEmployeeException() {}
	public DuplicateEmployeeException(String emp) 
	{
		super(emp);
	}
}