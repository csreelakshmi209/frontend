package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.DonateToNgo;
import com.model.Employee;
import com.service.DonateNgoServiceImpl;

@RestController
@CrossOrigin
public class DonateToNgoController {

	@Autowired
	DonateNgoServiceImpl donateSer;
	
	// add bank
	@PostMapping("/insertBank")
		public ResponseEntity<DonateToNgo> insertNgo( @RequestBody DonateToNgo donateNgo)
		{
			DonateToNgo insertedBank=donateSer.insertNgo(donateNgo);
			return new ResponseEntity<DonateToNgo>(insertedBank,HttpStatus.CREATED);
		}
	@GetMapping("/getBank")
	public ResponseEntity<List<DonateToNgo>> getBanks() {
		List<DonateToNgo> lcl = donateSer.getBanks();
		ResponseEntity<List<DonateToNgo>> re = new ResponseEntity<List<DonateToNgo>>(lcl, HttpStatus.OK);
		return re;
	}
	
	@PutMapping("/updateBank")
	public ResponseEntity<DonateToNgo>updateNgo(@RequestBody DonateToNgo donateNgo){
		DonateToNgo updatedBank=donateSer.updateNgo(donateNgo);
	    return new ResponseEntity<DonateToNgo>(updatedBank,HttpStatus.OK);
	}
	@DeleteMapping("/deleteBank")
	public ResponseEntity<DonateToNgo>deletengo(int ngoId){
		DonateToNgo deletedBank=donateSer.deleteNgo(ngoId);
		return new ResponseEntity<DonateToNgo>(deletedBank,HttpStatus.OK);
	}
		}

