package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.model.Employee;
import com.model.NeedyPeople;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	 @Query(value="Select phone from NeedyPeople needyPeople",nativeQuery = true)
		boolean checkIfUserAlreadyExists(String phone);


}