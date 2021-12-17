package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.DonationBox;
import com.model.Employee;

@Service
public interface IDonationBoxService {

	public DonationBox addDonationBox(DonationBox donationBox);

	public List<DonationBox> getDonationBox();

	public DonationBox modifyBox(int registrationNumber, DonationBox donationBox);

	public DonationBox removeBox(int registrationNumber);

	

	

	
}
