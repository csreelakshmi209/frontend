package com.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.exception.DuplicateEmployeeException;
import com.exception.NoSuchEmployeeException;
import com.model.Admin;
import com.model.Employee;
import com.service.IAdminLogService;
import com.service.IAdminService;

@RestController
@CrossOrigin
public class AdminLogController {

	@Autowired
	IAdminLogService adminService;
	
	@PostMapping("/admin/add")
	public ResponseEntity<Admin> addAdmin( @RequestBody Admin admin)
		 {
		Admin ad = adminService.addAdmin(admin);
		return new ResponseEntity<Admin>(ad, HttpStatus.CREATED);
	}
}
