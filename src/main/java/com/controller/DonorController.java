package com.controller;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.exception.DuplicateDonorException;
import com.exception.NoSuchDonorException;
import com.exception.NoSuchEmployeeException;
import com.model.Address;
import com.model.Donation;
import com.model.Donor;
import com.model.Employee;
import com.repository.DonorRepository;
import com.service.DonorServiceImpl;

@RestController
@CrossOrigin
public class DonorController {

	@Autowired
	DonorServiceImpl donorService;
	@Autowired
	DonorRepository donorRepo;

	// donor registration
	@PostMapping("/donor/add")
	public ResponseEntity<Donor> registerDonor(@Valid @RequestBody Donor donor) throws DuplicateDonorException, SQLException {
		Donor p = donorService.registerDonor(donor);
		return new ResponseEntity<Donor>(p, HttpStatus.CREATED);
	}

	// get all donors
	@GetMapping("/donor")
	public ResponseEntity<List<Donor>> getDonors() {
		List<Donor> d = donorService.getDonors();
		ResponseEntity<List<Donor>> re = new ResponseEntity<List<Donor>>(d, HttpStatus.OK);
		return re;
	}
	
	//get  employee address
	@GetMapping("/donor/get/{donorId}")
	public ResponseEntity<Donor> getDonorById(@PathVariable int donorId) {
		Donor lcl = donorService.getDonorById(donorId);
		ResponseEntity<Donor> re = new ResponseEntity<Donor>(lcl, HttpStatus.OK);
		return re;
	}

	// modify employee details
	@PutMapping(path = "/donor/update/{donorId}")
	public ResponseEntity<Donor> modifyEmployee(@PathVariable("donorId") int donorId,@RequestBody Donor donor) throws DuplicateDonorException, Throwable
	{
		Donor d1 = donorService.modifyDonor(donorId, donor);
		ResponseEntity<Donor> re = new ResponseEntity<Donor>(d1, HttpStatus.OK);
		return re;
	}
	
	//delete donor details
		@DeleteMapping(path = "donor/delete/{donorId}")
		public ResponseEntity<Donor> removeDonor(@PathVariable int donorId) throws DuplicateDonorException, NoSuchDonorException {
			Donor donor=donorService.removeDonor(donorId);

			ResponseEntity<Donor> re = new ResponseEntity<Donor>(HttpStatus.OK);
			return re;
		}

	// donor login
	@GetMapping("donor/login/{donorUsername}/{donorPassword}")
	public ResponseEntity<Donor> login(@Valid @PathVariable("donorUsername") String donorUsername,
			@PathVariable("donorPassword") String donorPassword) throws NoSuchDonorException {
		Donor user1 = new Donor(donorUsername, donorPassword);
		Donor user = donorService.login(user1);
		System.out.println("your login is completed");
		return new ResponseEntity<Donor>(user, HttpStatus.ACCEPTED);
	}

//	// donate to NGO
//	@PostMapping("/donation/add")
//	public ResponseEntity<?> donateToNGO(Donation donation) {
//		Donation addDonation = donorService.donateToNGO(donation);
//		return new ResponseEntity<Donation>(addDonation, HttpStatus.CREATED);
//	}

}
