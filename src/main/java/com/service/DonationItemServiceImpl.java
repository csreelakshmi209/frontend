package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.DonationItem;
import com.repository.DonationItemRepository;
import com.repository.DonationRepository;

@Service
public class DonationItemServiceImpl implements IDonationItemService{

	@Autowired
	DonationItemRepository donationItemRepo;
	
	@Autowired
	DonationRepository donationRepo;
	// add method for employee
		@Override
		public DonationItem addDonationItem(DonationItem donationItem) {
			int id = donationItem.getItemId();
//			if (id != 0) {
//				throw new DuplicateEmployeeException();
//			} 
			
				DonationItem dItem=new DonationItem();
				dItem.setItemId(donationItem.getItemId());
				dItem.setItemDescription(donationItem.getItemDescription());
				dItem.setItem(donationItem.getItem());
				dItem.setDonation(donationItem.getDonation());
				donationItemRepo.save(donationItem);
			return donationItem;
		}
	@Override
	public List<DonationItem> getDonationItems() {
		List<DonationItem> e = donationItemRepo.findAll();
		return e;
		
	}
}
