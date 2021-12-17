package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.NoSuchEmployeeException;
import com.model.DonationBox;
import com.model.Employee;
import com.repository.DonationBoxRepository;

@Service
public class DonationBoxServiceImpl implements IDonationBoxService{

	@Autowired
	DonationBoxRepository boxrepo;
	@Override
	public DonationBox addDonationBox(DonationBox donationBox) {
		
		DonationBox box=new DonationBox();
		box.setRegistrationNumber(donationBox.getRegistrationNumber());
		box.setAccountNumber(donationBox.getAccountNumber());
		box.setNgoName(donationBox.getNgoName());
		box.setTotalCollection(donationBox.getTotalCollection());
		boxrepo.save(donationBox);
		return donationBox;
	}
	@Override
	public List<DonationBox> getDonationBox() {
		List<DonationBox> e = boxrepo.findAll();
		return e;
	}
	@Override
	public DonationBox modifyBox(int registrationNumber, DonationBox donationBox) {
		Optional<DonationBox> optional = boxrepo.findById(registrationNumber);
		
		DonationBox box= optional.get();
		box.setRegistrationNumber(donationBox.getRegistrationNumber());
		box.setAccountNumber(donationBox.getAccountNumber());
		box.setNgoName(donationBox.getNgoName());
		box.setTotalCollection(donationBox.getTotalCollection());
		
		return boxrepo.save (donationBox);
	}
	@Override
	public DonationBox removeBox(int registrationNumber) {
		DonationBox donationBox = boxrepo.findById(registrationNumber).get();
		boxrepo.deleteById(registrationNumber);
		return donationBox;

	}
	
}
