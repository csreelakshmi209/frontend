package com.service;

import org.springframework.stereotype.Service;

import com.model.Admin;
import com.model.Employee;

@Service
public interface IAdminLogService {

	public Admin addAdmin(Admin admin);
}
