package com.service;

import org.springframework.stereotype.Service;

import com.model.Address;

@Service
public interface IAddressService {
	public Address getEmpAddressById(int addressId);
	public Address getDonorAddressById(int addressId);
	public Address addEmpAddress(Address address);
}
