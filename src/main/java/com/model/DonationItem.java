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
	private DonationType donationType;

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
	


	public DonationType getDonationType() {
		return donationType;
	}



	public void setDonationType(DonationType donationType) {
		this.donationType = donationType;
	}



	public DonationItem() {
		super();
		
	}

	@Override
	public String toString() {
		return "DonationItem [dItemId=" + dItemId + ", itemDescription=" + itemDescription + ", donationType="
				+ donationType + "]";
	}


}