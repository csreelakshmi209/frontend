package com.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.exception.DuplicateEmployeeException;
import com.exception.NoSuchEmployeeException;
import com.model.DonationBox;
import com.model.Employee;
import com.service.IDonationBoxService;

@RestController
@CrossOrigin
public class DonationBoxController {
	@Autowired
	IDonationBoxService idonationBoxSer;
	
	// add donationBox details
		@PostMapping("/donationBox/add")
		public ResponseEntity<DonationBox> addDonationBox( @RequestBody DonationBox donationBox)
				throws SQLException, NoSuchEmployeeException, DuplicateEmployeeException {
			DonationBox emp = idonationBoxSer.addDonationBox(donationBox);
			return new ResponseEntity<DonationBox>(emp, HttpStatus.CREATED);
		}
		
		//get all employees
		@GetMapping("/donationBox/get")
		public ResponseEntity<List<DonationBox>> getDonationBox() {
			List<DonationBox> lcl = idonationBoxSer.getDonationBox();
			ResponseEntity<List<DonationBox>> re = new ResponseEntity<List<DonationBox>>(lcl, HttpStatus.OK);
			return re;
		}
		
		// modify employee details
		@PutMapping(path = "/donationBox/update/{registrationNumber}")
		public ResponseEntity<Employee> modifyEmployee(@PathVariable("registrationNumber") int employeeId,@RequestBody Employee employee) throws NoSuchEmployeeException, Throwable  {
			Employee e1 = idonationBoxSer.modifyEmployee(employeeId,employee);

			ResponseEntity<Employee> re = new ResponseEntity<Employee>(e1, HttpStatus.OK);
			return re;
		}
}
