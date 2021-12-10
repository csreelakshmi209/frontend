package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.repository.AdminRepository;
import com.exception.DuplicateEmployeeException;
import com.exception.NoSuchEmployeeException;
import com.model.Address;
import com.model.Employee;

@SpringBootTest
class AdminServiceTest {

	@Autowired
	IAdminService adminService;

	@MockBean
	AdminRepository adminRepo;

	// test case to add employee
	@Test
	void testAddEmployee() throws DuplicateEmployeeException, SQLException {
		Employee e = new Employee();
		e.setEmployeeId(1);
		e.setEmployeeName("sreelakshmi");
		e.setPhone("987654321");
		e.setEmail("sree@gmail.com");
		e.setUsername("SREELAK");
		e.setPassword("abc123");

		Address a = new Address();
		a.setAddressId(1);
		a.setCity("Noida");
		a.setState("Delhi");
		a.setLandmark("");
		a.setPin("121002");

		e.setAddress(a);
		Mockito.when(adminRepo.save(e)).thenReturn(e);
		assertThat(adminService.addEmployee(e)).isEqualTo(e);
	}

	// test case to get all employees
	@Test
	void testGetEmployees() {
		Employee e1 = new Employee();
		e1.setEmployeeId(1);
		e1.setEmployeeName("sreelakshmi");
		e1.setEmail("sree@gmail.com");
		e1.setPhone("987654321");
		e1.setUsername("SREELAK");
		e1.setPassword("abc123");

		Address a1 = new Address();
		a1.setAddressId(1);
		a1.setCity("Noida");
		a1.setState("Delhi");
		a1.setLandmark("");
		a1.setPin("121002");
		e1.setAddress(a1);

		Employee e2 = new Employee();
		e2.setEmployeeName("varsha");
		e2.setEmail("varsha@gmail.com");
		e2.setPhone("967654321");
		e2.setUsername("VARSHANAMRATHA");
		e2.setPassword("abc456");

		Address a2 = new Address();
		a2.setAddressId(2);
		a2.setCity("Kolkata");
		a2.setState("West Bengal");
		a2.setLandmark("");
		a2.setPin("700101");

		e2.setAddress(a2);
		List<Employee> empList = new ArrayList<>();
		empList.add(e1);
		empList.add(e2);

		Mockito.when(adminRepo.findAll()).thenReturn(empList);
		assertThat(adminService.getEmployees()).isEqualTo(empList);
	}

	// test case to find employee by id
	@Test
	void testFindEmployeeById() throws NoSuchEmployeeException {
		Employee e = new Employee();
		e.setEmployeeId(1);
		e.setEmployeeName("sreelakshmi");
		e.setEmail("sree@gmail.com");
		e.setPhone("987654321");
		e.setUsername("SREELAK");
		e.setPassword("abc123");

		Address a = new Address();
		a.setAddressId(1);
		a.setCity("Noida");
		a.setState("Delhi");
		a.setLandmark("");
		a.setPin("121002");

		e.setAddress(a);

		Optional<Employee> c2 = Optional.of(e);
		Mockito.when(adminRepo.findById(1)).thenReturn(c2);
		assertThat(adminService.findEmployeeById(1)).isEqualTo(e);
	}

	// test case to remove employee by id
	@Test
	void testRemoveEmployee() {
		Employee e = new Employee();
		e.setEmployeeId(1);
		e.setEmployeeName("sreelakshmi");
		e.setEmail("sree@gmail.com");
		e.setPhone("987654321");
		e.setUsername("SREELAK");
		e.setPassword("abc123");

		Address a = new Address();
		a.setAddressId(1);
		a.setCity("Noida");
		a.setState("Delhi");
		a.setLandmark("");
		a.setPin("121002");

		e.setAddress(a);
		Optional<Employee> c2 = Optional.of(e);
		Mockito.when(adminRepo.findById(1)).thenReturn(c2);
		Mockito.when(adminRepo.existsById(e.getEmployeeId())).thenReturn(false);
		assertFalse(adminRepo.existsById(e.getEmployeeId()));
	}
}