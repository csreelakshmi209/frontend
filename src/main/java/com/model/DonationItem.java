package com.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "donation_item")
public class DonationItem implements Serializable {

	// donation fields
	@Id
	@GeneratedValue
	@Column(name = "item_id")
	private int dItemId;
	
	@Column(name = "item_description")
	private String itemDescription;

	// enum mapping to donationType
	@Enumerated(EnumType.STRING)
	private DonationType item;

//	// mapping to donation
//	@OneToOne(cascade = CascadeType.ALL)
//	private Donation donation;
	

//	public Donation getDonation() {
//		return donation;
//	}
//
//	public void setDonation(Donation donation) {
//		this.donation = donation;
//	}


	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "donor_id", referencedColumnName = "donor_id")
	Donor donor;
	// getters and setters

	

	

	public String getItemDescription() {
		return itemDescription;
	}

	

	public int getdItemId() {
		return dItemId;
	}

	public void setdItemId(int dItemId) {
		this.dItemId = dItemId;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public DonationType getItem() {
		return item;
	}
	public void setItem(DonationType item) {
		this.item = item;
	}
	public Donor getDonor() {
		return donor;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}

	public DonationItem() {
		super();
		
	}

	@Override
	public String toString() {
		return "DonationItem [dItemId=" + dItemId + ", itemDescription=" + itemDescription + ", item=" + item
				+ ", donor=" + donor + "]";
	}


}