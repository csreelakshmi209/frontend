package com.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.NoSuchEmployeeException;
import com.model.Address;
import com.model.Employee;
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
		
		@Override
		public Address addEmpAddress(Address address) {
			Address a=new Address();
			a.setCity(address.getCity());
			a.setState(address.getState());
			a.setPin(address.getPin());
			a.setLandmark(address.getLandmark());
			
			
			return addrepo.save(address);
		}
		@Override
		public Address modifyEmpAddress(int addressId, Address address) {
			Optional<Address> optional = addrepo.findById(addressId);
			
			Address add=optional.get();
			
			add.setCity(address.getCity());
			add.setState(address.getState());
			add.setPin(address.getPin());
			add.setLandmark(address.getLandmark());
			return addrepo.save(address);
		}
	
}
