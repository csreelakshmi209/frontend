package com.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.model.Employee;
@Repository
public interface AdminRepository extends JpaRepository<Employee, Integer> {


	Employee findByEmployeeName(String name);
	 @Query(value="Select email from employee",nativeQuery = true)
	 String checkIfUserAlreadyExists(String email);
}
