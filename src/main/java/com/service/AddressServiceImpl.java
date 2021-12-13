package com.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.Address;
import com.repository.AddressRepository;
import com.repository.DonorRepository;

@Service
public class AddressServiceImpl implements IAddressService{
	
	@Autowired
	DonorRepository donorRepo;
	
	
	
	@Autowired
	AddressRepository addrepo;
		//get all donor addresses
		@Override
		public Address getDonorAddressById(int addressId) {
			Optional<Address> e = addrepo.findById(addressId);
			return e.get();
		}
		//get all employee addresses
		@Override
		public Address getEmpAddressById(int addressId) {
			Optional<Address> e = addrepo.findById(addressId);
			return e.get();
		}
	
}
