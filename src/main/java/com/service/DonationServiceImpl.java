package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.NoSuchEmployeeException;
import com.model.Donation;
import com.model.DonationItem;
import com.model.Employee;
import com.repository.DonationRepository;

@Service
public class DonationServiceImpl implements IDonationService{

	@Autowired
	DonationRepository donationRepo;
	@Override
	public Donation addDonation(Donation donation) {
		
		Donation d=new Donation();
		d.setDonor(donation.getDonor());
		d.setDonationAmount(donation.getDonationAmount());
		d.setItem(donation.getItem());
		d.setDonationDate(donation.getDonationDate());
		donationRepo.save(donation);
		
		return donation;
		
	}
	
	// get all donation data
		@Override
		public List<Donation> getDonations() {
			List<Donation> e = donationRepo.findAll();

			return e;
		}

		// update the donation details
		@Override
		public Donation updateDonation(int donationId, Donation donation) {
			
			Optional<Donation> optional = donationRepo.findById(donationId);
			
			Donation d=new Donation();
			d.setDonor(donation.getDonor());
			d.setDonationAmount(donation.getDonationAmount());
			d.setItem(donation.getItem());
			d.setDonationDate(donation.getDonationDate());
			donationRepo.save(donation);
			    
			return donationRepo.save (donation);
			}
		
		//remove donation type
		@Override
		public Donation removeDonation(int donationId) {
			Donation donation = donationRepo.findById(donationId).get();
			donationRepo.deleteById(donationId);
			return donation;
			
		}

}
