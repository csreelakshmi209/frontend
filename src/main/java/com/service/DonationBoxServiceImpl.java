package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		box.setAccountNumber(donationBox.getAccountNumber());
		box.setNgoName(donationBox.getNgoName());
		box.setTotalCollection(donationBox.getTotalCollection());
		box.setDonation(donationBox.getDonation());
		boxrepo.save(donationBox);
		return donationBox;
	}
	@Override
	public List<DonationBox> getDonationBox() {
		List<DonationBox> e = boxrepo.findAll();
		return null;
	}
	@Override
	public Employee modifyEmployee(int employeeId, Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
