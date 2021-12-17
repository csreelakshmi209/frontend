package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.NoSuchEmployeeException;
import com.model.Address;
import com.model.DonationItem;
import com.model.Employee;
import com.repository.DonationItemRepository;
import com.repository.DonationRepository;

@Service
public class DonationItemServiceImpl implements IDonationItemService {

	@Autowired
	DonationItemRepository donationItemRepo;

	@Autowired
	DonationRepository donationRepo;

	// add method for item
	@Override
	public DonationItem addDonationItem(DonationItem donationItem) {
		int id = donationItem.getdItemId();

		DonationItem dItem = new DonationItem();
		dItem.setdItemId(donationItem.getdItemId());
		dItem.setItemDescription(donationItem.getItemDescription());
		dItem.setDonationType(donationItem.getDonationType());
		//dItem.setDonation(donationItem.getDonation());
		donationItemRepo.save(donationItem);
		return donationItem;
	}

	// get items
	@Override
	public List<DonationItem> getDonationItems() {
		List<DonationItem> e = donationItemRepo.findAll();
		return e;

	}
	// update the item details

	@Override
	public DonationItem updateDonationItem(int itemId, DonationItem donationItem) {

		Optional<DonationItem> optional = donationItemRepo.findById(itemId);
		
		DonationItem d = optional.get();

		d.setDonationType(donationItem.getDonationType());
		d.setItemDescription(donationItem.getItemDescription());
//		d.setDonation(donationItem.getDonation());
		return donationItemRepo.save(d);
	}

	// remove the item data
	@Override
	public DonationItem removeDonationItem(int itemId) {
		DonationItem d = donationItemRepo.findById(itemId).get();
		donationItemRepo.deleteById(itemId);
		return d;

	}

	@Override
	public DonationItem getdonationItemById(int itemId) {
			Optional<DonationItem> e = donationItemRepo.findById(itemId);
			return e.get();
		}

}
