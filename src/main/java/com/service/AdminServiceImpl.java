package com.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repository.AdminRepository;
import com.dto.EmployeeDto;
import com.exception.DuplicateEmployeeException;
import com.exception.NoSuchEmployeeException;
import com.model.Address;
import com.model.DonationDistribution;
import com.model.Employee;

@Service
public class AdminServiceImpl implements IAdminService {
	//employee services that was handled by the admin
	
	@Autowired
	AdminRepository adminRepo;
	
	
	
//implementation methods

	// add method for employee
	@Override
	public Employee addEmployee(Employee employee) throws DuplicateEmployeeException, SQLException {
		int id = employee.getEmployeeId();
		if (id != 0) {
			throw new DuplicateEmployeeException();
		} else {
			Employee emp=new Employee();
			emp.setPhone(employee.getPhone());
			emp.setEmployeeName(employee.getEmployeeName());
			emp.setEmail(employee.getEmail());
			emp.setUsername(employee.getUsername());
			emp.setPassword(employee.getPassword());
			
			Address add=new Address();
			add.setCity(employee.getAddress().getCity());
			add.setState(employee.getAddress().getState());
			add.setPin(employee.getAddress().getPin());
			add.setLandmark(employee.getAddress().getLandmark());
			
			adminRepo.save(employee);
		}
		return employee;
	}

	// get all employees data
	@Override
	public List<Employee> getEmployees() {
		List<Employee> e = adminRepo.findAll();

		return e;
	}
	
	// update the employee details
	@Override
	public Employee modifyEmployee(int employeeId,Employee employee) throws Throwable {
		
		Optional<Employee> optional = adminRepo.findById(employeeId);
		if(!optional.isPresent()) {
			throw new NoSuchEmployeeException("Employee Does not exist in the database");
		}
		Employee emp = optional.get();
		
		emp.setEmployeeName(employee.getEmployeeName());
		emp.setPhone(employee.getPhone());
		emp.setEmail(employee.getEmail());
	    emp.setUsername(employee.getUsername());
	    emp.setPassword(employee.getPassword());
	    emp.setAddress(employee.getAddress());
	    
		
	    
	    
		return adminRepo.save (employee);
	}

	// remove the employee data
	@Override
	public Employee removeEmployee(int employeeId) throws NoSuchEmployeeException {
		Employee employee = adminRepo.findById(employeeId).get();
		adminRepo.deleteById(employeeId);
		return employee;

	}

	// find employee by using id
	@Override
	public EmployeeDto findEmployeeById(int employeeId) throws NoSuchEmployeeException {
		
		Optional<Employee> employee = adminRepo.findById(employeeId);
		if(!employee.isPresent()) {
			throw new NoSuchEmployeeException("Student not found with given employeeId "+employeeId);
		}
		
		Employee emp = employee.get();
		
		// Create dto obj
		EmployeeDto dto = new EmployeeDto();
		
		// update dto with employee details	
		dto.setEmployeeName(emp.getEmployeeName());
		dto.setEmail(emp.getEmail());
		dto.setPhone(emp.getPhone());
		dto.setUsername(emp.getUsername());
		dto.setPassword(emp.getPassword());
		return dto;

	}

	// find employee by using name
	@Override
	public Employee findEmployeeByName(String name) throws NoSuchEmployeeException {
		Employee e = adminRepo.findByEmployeeName(name);
		return e;

	}

	// final check to approve donation
	@Override
	public boolean approveDonation(DonationDistribution distribution) {
		System.out.println("donation was approved");
		return false;
	}

	

	


}