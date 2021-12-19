package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.NoSuchEmployeeException;

import com.model.DonationDistribution;
import com.model.Employee;
import com.model.NeedyPeople;
import com.repository.EmployeeRepository;
import com.repository.NeedyPeopleRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	EmployeeRepository empRepository;
	
	@Autowired
	NeedyPeopleRepository needyPeople;
	
	@Override
	public Employee login(Employee employee) throws NoSuchEmployeeException {
		Employee emp=empRepository.findById(employee.getEmployeeId()).orElse(null);
		if(emp==null) {
			String noSuchEmployee="No Donor found by the donor id"+employee.getEmployeeId();
			throw new  NoSuchEmployeeException (noSuchEmployee);
		}
		else {
			if(employee.getUsername().equals(emp.getUsername()) && employee.getPassword().equals(emp.getPassword())){
				return emp;
			}
			else {
				throw new NoSuchEmployeeException("Employee username and password are invalid");
			}
		}	
	}

	@Override
	public NeedyPeople addNeedyPerson(NeedyPeople person) {
		needyPeople.save(person);
		return person;
	}

	@Override
	public boolean removeNeedyPerson(NeedyPeople person) {
		needyPeople.delete(person);
		return true;
	}

	@Override
	public NeedyPeople findNeedyPeopleById(int id) {
		NeedyPeople n=needyPeople.findById(id).get();
		return n;
	}

	@Override
	public List<NeedyPeople> findAllNeedyPeople() {
		List<NeedyPeople> ln=needyPeople.findAll();
		return ln;
	}


	@Override
	public NeedyPeople findNeedyPeopleByName(String name) {
		NeedyPeople n=needyPeople.findByNeedyPersonName(name);
		return n;
	}

}