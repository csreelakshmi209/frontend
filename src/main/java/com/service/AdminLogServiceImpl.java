package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.DuplicateEmployeeException;
import com.model.Address;
import com.model.Admin;
import com.model.Employee;
import com.model.Login;
import com.repository.IAdminRepo;

@Service
public class AdminLogServiceImpl implements IAdminLogService{

	@Autowired
	IAdminRepo adminrepo;
	@Override
	public Admin addAdmin(Admin admin) {
		int id = admin.getAdminId();
		Admin ad=new Admin();
		ad.setAdminUsername(admin.getAdminUsername());
		ad.setAdminPassword(admin.getAdminPassword());
		ad.setLogin(admin.getLogin());
//		Login login = new Login();
//		login.setUsername(admin.getLogin().getUsername());
//		login.setRole(admin.getLogin().getRole());
//		login.setPassword(admin.getLogin().getPassword());
//		ad.setLogin(login);
		
			
		adminrepo.save(admin);
		return admin;
		
	}

}
