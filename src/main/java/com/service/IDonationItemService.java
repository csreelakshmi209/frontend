package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.DonationItem;

@Service
public interface IDonationItemService {
	public DonationItem addDonationItem(DonationItem donationItem);

	public List<DonationItem> getDonationItems();

	public DonationItem updateDonationItem(int itemId, DonationItem donationItem);

	public DonationItem removeDonationItem(int itemId);
}
