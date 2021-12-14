package com.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.exception.DuplicateEmployeeException;
import com.exception.NoSuchEmployeeException;
import com.model.Donation;
import com.model.Donor;
import com.model.Employee;
import com.service.IDonationItemService;
import com.service.IDonationService;

@RestController
@CrossOrigin
public class DonationController {

	@Autowired
	IDonationService donationSer;
	
	
	// add donation
		@PostMapping("/donation/add")
		public ResponseEntity<Donation> addDonation( @RequestBody Donation donation)
		 {
			Donation d = donationSer.addDonation(donation);
			return new ResponseEntity<Donation>(d, HttpStatus.CREATED);
		}
		
		//get all donations
		@GetMapping("/donation/get")
		public ResponseEntity<List<Donation>> getDonations() {
			List<Donation> d = donationSer.getDonations();
			ResponseEntity<List<Donation>> re = new ResponseEntity<List<Donation>>(d, HttpStatus.OK);
			return re;
		}
		//get  employee address
		@GetMapping("/donation/donor/{donorId}")
		public ResponseEntity<Donation> getDonationDonorById(@PathVariable int donorId) {
			Donation lcl = donationSer.getDonationDonorById(donorId);
			ResponseEntity<Donation> re = new ResponseEntity<Donation>(lcl, HttpStatus.OK);
			return re;
		}
		
		// modify donation details
		@PutMapping(path = "/donation/update/{donationId}")
		public ResponseEntity<Donation> updateDonation(@PathVariable("employeeId") int donationId,@RequestBody Donation donation) throws Exception  {
			Donation e1 = donationSer.updateDonation(donationId,donation);

			ResponseEntity<Donation> re = new ResponseEntity<Donation>(e1, HttpStatus.OK);
			return re;
		}
		
		//delete donation details
		@DeleteMapping(path = "/donation/remove/{donationId}")
		public ResponseEntity<Donation> removeDonation(@PathVariable int donationId) throws NoSuchEmployeeException {
			Donation donation =donationSer.removeDonation(donationId);

			ResponseEntity<Donation> re = new ResponseEntity<Donation>(HttpStatus.OK);
			return re;
		}
}
