package com.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "donor")
public class Donor implements Serializable {
	// donor fields

	@Id
	@GeneratedValue
	@Column(name = "donor_id")
	private int donorId;
	@NotNull
	@Size(min = 3, message = "First Name should have atleast 3 characters")
	@Column(name = "donor_name")
	private String donorName;
	@NotNull
	@Email
	@Column(name = "donor_email", unique = true)
	private String donorEmail;
	@NotNull
	@Column(name = "donor_phone")
	private String donorPhone;
	@NotNull
	@Column(name = "donor_username")
	private String donorUsername;
	@NotNull
	@Size(min = 8, message = "password should have atleast 8 characters")
	@Column(name = "donor_password")
	private String donorPassword;

	// mapping to address
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;
	
	@OneToMany
	List<DonationItem> donationitems;
	
	//default constructor
	public Donor() {}
	
	// parametarised constructor
	public Donor(@NotNull String donorUsername, @NotNull String donorPassword) {
		this.donorUsername = donorUsername;
		this.donorPassword = donorPassword;
	}

	// getters and setters

	public int getDonorId() {
		return donorId;
	}

	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}

	public String getDonorName() {
		return donorName;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}

	public String getDonorEmail() {
		return donorEmail;
	}

	public void setDonorEmail(String donorEmail) {
		this.donorEmail = donorEmail;
	}

	public String getDonorPhone() {
		return donorPhone;
	}

	public void setDonorPhone(String donorPhone) {
		this.donorPhone = donorPhone;
	}

	public String getDonorUsername() {
		return donorUsername;
	}

	public void setDonorUsername(String donorUsername) {
		this.donorUsername = donorUsername;
	}

	public String getDonorPassword() {
		return donorPassword;
	}

	public void setDonorPassword(String donorPassword) {
		this.donorPassword = donorPassword;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	// to string
	@Override
	public String toString() {
		return "Donor [donorId=" + donorId + ", donorName=" + donorName + ", donorEmail=" + donorEmail + ", donorPhone="
				+ donorPhone + ", donorUsername=" + donorUsername + ", donorPassword=" + donorPassword + ", address="
				+ address + "]";
	}

}