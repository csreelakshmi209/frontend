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
	private int itemId;
	@Column(name = "item_description")
	private String itemDescription;

	// enum mapping to donationType
	@Enumerated(EnumType.STRING)
	private DonationType item;

	// mapping to donation
	@OneToOne(cascade = CascadeType.ALL)
	private Donation donation;
	

	public Donation getDonation() {
		return donation;
	}

	public void setDonation(Donation donation) {
		this.donation = donation;
	}


	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "donor_id", referencedColumnName = "donor_id")
	Donor donor;
	// getters and setters

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public DonationType getItem() {
		return item;
	}

	public void setItem(DonationType item) {
		this.item = item;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	// to string
	@Override
	public String toString() {
		return "DonationItem [itemId=" + itemId + ", itemDescription=" + itemDescription + ", item=" + item
				+ ", donation=" + donation + "]";
	}

}