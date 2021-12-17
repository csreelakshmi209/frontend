package com.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class DonationBox implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int registrationNumber;
	@NotNull
	private String accountNumber;
	@NotNull
	private String ngoName;
	@NotNull
	private double totalCollection;
	
	// mapping to donation
//		@OneToOne(cascade = CascadeType.ALL)
//		@JoinColumn(name="donation_id")
//		private Donation donation;
		
//	public Donation getDonation() {
//			return donation;
//		}
//		public void setDonation(Donation donation) {
//			this.donation = donation;
//		}
	public String getNgoName() {
		return ngoName;
	}
	public void setNgoName(String ngoName) {
		this.ngoName = ngoName;
	}
	
	public int getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getTotalCollection() {
		return totalCollection;
	}
	public void setTotalCollection(double totalCollection) {
		this.totalCollection = totalCollection;
	}
	@Override
	public String toString() {
		return "DonationBox [registrationNumber=" + registrationNumber + ", accountNumber=" + accountNumber
				+ ", ngoName=" + ngoName + ", totalCollection=" + totalCollection + "]";
	}
	

}