package com.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.EmployeeDto;
import com.exception.DuplicateEmployeeException;
import com.exception.NoSuchEmployeeException;
import com.model.Admin;
import com.model.DonationDistribution;
import com.model.Employee;
@Service
public interface IAdminService {
	
	public Employee addEmployee(Employee employee) throws DuplicateEmployeeException, SQLException ;
	public Employee modifyEmployee(int employeeId, Employee employee) throws NoSuchEmployeeException, Throwable;
	public Employee removeEmployee(int employeeId) throws NoSuchEmployeeException;
	public EmployeeDto findEmployeeById(int employeeId) throws NoSuchEmployeeException;
	public Employee findEmployeeByName(String name) throws NoSuchEmployeeException;
	public boolean approveDonation(DonationDistribution distribution);
	List<Employee> getEmployees();
	
	
	

}