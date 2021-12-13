package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.model.Address;
import com.model.Donor;
import com.service.AddressServiceImpl;
import com.service.DonorServiceImpl;



@RestController
@CrossOrigin
public class AddressController {

	@Autowired
	AddressServiceImpl addressService;
	
	
		//get  donor address
		@GetMapping("/donor/get/address/{addressId}")
		public ResponseEntity<Address> getDonorAddressById(@PathVariable int addressId) {
			Address lcl = addressService.getDonorAddressById(addressId);
			ResponseEntity<Address> re = new ResponseEntity<Address>(lcl, HttpStatus.OK);
			return re;
		}
		
			//get  employee address
				@GetMapping("/employee/get/address/{addressId}")
				public ResponseEntity<Address> getEmpAddressById(@PathVariable int addressId) {
					Address lcl = addressService.getEmpAddressById(addressId);
					ResponseEntity<Address> re = new ResponseEntity<Address>(lcl, HttpStatus.OK);
					return re;
				}
				
				
		
}
