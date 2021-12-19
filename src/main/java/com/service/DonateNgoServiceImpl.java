package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Admin;
import com.model.DonateToNgo;
import com.model.Employee;
import com.repository.IDonateNgoRepo;

@Service
public class DonateNgoServiceImpl {

	@Autowired
	IDonateNgoRepo donateNgoRepo;
	
	public DonateToNgo insertNgo(DonateToNgo donateNgo)
	{
	return donateNgoRepo.save(donateNgo);
	}
	
	
	public DonateToNgo updateNgo(DonateToNgo donateNgo) {
		int bankId=donateNgo.getNgoId();
		Optional<DonateToNgo> optional=donateNgoRepo.findById(bankId);
		
			DonateToNgo b1=optional.get();
			b1.setBankName(donateNgo.getBankName());
			DonateToNgo updatedBank=donateNgoRepo.save(b1);
		
		return updatedBank;
	}
	public DonateToNgo deleteNgo(int ngoId) {
		Optional<DonateToNgo> optional=donateNgoRepo.findById(ngoId);
	
			DonateToNgo deletedNgo=optional.get();
			donateNgoRepo.deleteById(ngoId);
			return deletedNgo;
		
}


	public List<DonateToNgo> getBanks() {
		List<DonateToNgo> e = donateNgoRepo.findAll();
		return e;
	}


	
	}
