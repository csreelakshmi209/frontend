package com.service;

import java.util.List;

import com.exception.NoSuchEmployeeException;
import com.model.Donation;
import com.model.Donor;
import com.model.Employee;

public interface IDonationService {
	public Donation addDonation(Donation donation);
	public Donation updateDonation(int donationId, Donation donation) throws Exception ;
	public Donation removeDonation(int donationId) ;
	public List<Donation> getDonations();
	public Donation getDonationDonorById(int donorId);
}
