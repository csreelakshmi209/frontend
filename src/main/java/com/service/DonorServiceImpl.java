package com.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repository.DonationRepository;
import com.repository.DonorRepository;
import com.exception.DuplicateDonorException;
import com.exception.NoSuchDonorException;
import com.model.Address;
import com.model.Donation;
import com.model.Donor;
import com.model.Employee;

@Service
public class DonorServiceImpl implements IDonorService {

	//donor services 
	@Autowired
	DonorRepository donorRepo;

	@Autowired
	DonationRepository donationRepo;

	

	// implemented methods

	// register donor
	@Override
	public Donor registerDonor(Donor donor) throws DuplicateDonorException,SQLException {

		int id = donor.getDonorId();
		if (id != 0) {
			throw new DuplicateDonorException("Data already exists with this donor");
		} else {
			
			Donor d = new Donor();
			
			d.setDonorName(donor.getDonorName());
			d.setDonorEmail(donor.getDonorEmail());
			d.setDonorPhone(donor.getDonorPhone());
			d.setDonorUsername(donor.getDonorUsername());
			d.setDonorPassword(donor.getDonorPassword());
			
			donorRepo.save(donor);
		}
		return donor;
	}
	//get all donors
	@Override
	public List<Donor> getDonors() {
		List<Donor> e = donorRepo.findAll();
		return e;
	}
	
	public Donor getDonorById(int donorId) {
		Optional<Donor> e = donorRepo.findById(donorId);
		return e.get();
		
	}
	
	//modify donor details
	@Override
	public Donor modifyDonor(int donorId, Donor donor) throws DuplicateDonorException, Throwable {
		Optional<Donor> optional = donorRepo.findById(donorId);
		if(!optional.isPresent()) {
			throw new DuplicateDonorException("Donor Does not exist in the database");
		}
		Donor d = optional.get();
		
		d.setDonorName(donor.getDonorName());
		d.setDonorEmail(donor.getDonorEmail());
		d.setDonorPhone(donor.getDonorPhone());
		d.setDonorUsername(donor.getDonorUsername());
		d.setDonorPassword(donor.getDonorPassword());
		
	   	return donorRepo.save (d);
		
	}
	
	//delete a donor
	@Override
	public Donor removeDonor(int donorId) throws NoSuchDonorException {
		Donor donor = donorRepo.findById(donorId).get();
		donorRepo.deleteById(donorId);
		return donor;
		
	}

	// donor login
	@Override
	public Donor login(Donor donor) throws NoSuchDonorException {
		Donor doid = donorRepo.findById(donor.getDonorId()).orElse(null);
		if (doid == null) {
			String NoSuchDonor = "No Donor found by the donor id" + donor.getDonorId();
			throw new NoSuchDonorException(NoSuchDonor);
		} else {
			if (donor.getDonorUsername().equals(doid.getDonorUsername())
					&& donor.getDonorPassword().equals(doid.getDonorPassword())) {
				return doid;
			} else {
				throw new NoSuchDonorException("Donor username and password are invalid");
			}
		}

	}

	// donation giving to NGO
	@Override
	public Donation donateToNGO(Donation donation) {

		return donationRepo.save(donation);
	}

	// send gratitude to the donator
	@Override
	public void sendThankyouMailToDonator(Donor donor) {
		System.out.println("Thankyou for donating");

	}
	Donor donor = null;
	// donor forgot password
	@Override
	public String forgotPassword(String username, String password) {

		
		if (donor.getDonorUsername().equals(username)) {
			if (!donor.getDonorPassword().equals(password)) {
				System.out.println("your password is not correct try to reset your password");
				return password;
			}
		}
		return username;
	}

	// donor reset password
	@Override
	public String resetPassword(String username, String password) {
		if (donor.getDonorUsername().equals(username)) {
			System.out.println("click here to reset your password");
			donor.setDonorPassword(password);
		}
		return username;
	}

	// send donor password to mail
	@Override
	public void emailPasswordToDonor(String email) {
		System.out.println("click here to get your the password");

	}
	
	
	

	





}