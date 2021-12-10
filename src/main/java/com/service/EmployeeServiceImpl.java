package com.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repository.AdminRepository;
import com.repository.EmployeeRepository;
import com.repository.NeedyPeopleRepository;
import com.exception.NoSuchEmployeeException;
import com.exception.NoSuchNeedyPeopleException;
import com.model.DonationDistribution;
import com.model.Employee;
import com.model.NeedyPeople;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	// needy people details that was handled by employees
	@Autowired
	EmployeeRepository empRepo;

	@Autowired
	NeedyPeopleRepository needyRepo;

	// implemented methods

	// employee login
	@Override
	public Employee login(Employee employee) throws NoSuchEmployeeException, SQLException {
		Employee emp = empRepo.findById(employee.getEmployeeId()).orElse(null);
		if (emp == null) {
			String noSuchEmployee = "No Donor found by the donor id" + employee.getEmployeeId();
			throw new NoSuchEmployeeException(noSuchEmployee);
		} else {
			if (employee.getUsername().equals(emp.getUsername()) && employee.getPassword().equals(emp.getPassword())) {
				return emp;
			} else {
				throw new NoSuchEmployeeException("Employee username and password are invalid");
			}
		}

	}

	// add needy person
	@Override
	public NeedyPeople addNeedyPerson(NeedyPeople person) {
		needyRepo.save(person);

		return person;
	}

	// remove needy person
	@Override
	public boolean removeNeedyPerson(NeedyPeople person) {
		needyRepo.delete(person);
		return true;

	}

	// find needy person by id
	@Override
	public NeedyPeople findNeedyPeopleById(int id) {
		NeedyPeople n = needyRepo.findById(id).get();
		return n;
	}

	// find needy person by name
	@Override
	public NeedyPeople findNeedyPeopleByName(String name) {

		NeedyPeople n = needyRepo.findByNeedyPersonName(name);
		return n;

	}

	// get all needy peoples
	@Override
	public List<NeedyPeople> findAllNeedyPeople() {
		List<NeedyPeople> n = needyRepo.findAll();
		return n;
	}

}