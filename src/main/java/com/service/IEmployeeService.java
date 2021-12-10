package com.service;

import java.sql.SQLException;
import java.util.List;
import java.util.function.IntPredicate;

import com.exception.NoSuchEmployeeException;
import com.model.DonationDistribution;
import com.model.Employee;
import com.model.NeedyPeople;

public interface IEmployeeService {
	public Employee  login(Employee employee)throws NoSuchEmployeeException, SQLException;
	public NeedyPeople addNeedyPerson(NeedyPeople person);
	public boolean removeNeedyPerson(NeedyPeople person);
	public NeedyPeople findNeedyPeopleById(int id);
	public NeedyPeople findNeedyPeopleByName(String name);
	public List<NeedyPeople> findAllNeedyPeople();
	
	
}