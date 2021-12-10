package com.service;

import java.sql.SQLException;
import java.util.List;

import com.exception.DuplicateDonorException;
import com.exception.NoSuchDonorException;
import com.exception.NoSuchEmployeeException;
import com.model.Donation;
import com.model.Donor;
import com.model.Employee;

public interface IDonorService {
	public Donor registerDonor(Donor donor) throws DuplicateDonorException, SQLException;
	public Donor modifyDonor(int donorId, Donor donor) throws DuplicateDonorException, Throwable;
	public Donor removeDonor(int donorId, Donor donor) throws NoSuchDonorException;
	List<Donor> getDonors();
	public Donor login(Donor donor) throws NoSuchDonorException;
	public Donation donateToNGO(Donation donation);
	public void sendThankyouMailToDonator(Donor donor);
	public String forgotPassword(String username,String password);
	
	public void emailPasswordToDonor(String email);
	public String resetPassword(String username, String password);

}