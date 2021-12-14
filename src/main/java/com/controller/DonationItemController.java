package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exception.NoSuchEmployeeException;
import com.model.Address;
import com.model.DonationItem;
import com.model.Employee;
import com.service.IDonationItemService;

@RestController
@CrossOrigin
public class DonationItemController {

	@Autowired
	IDonationItemService ditemService;
	
	//add donation item
		@PostMapping("/items/add")
		public ResponseEntity<DonationItem> addDonationItem( @RequestBody DonationItem donationItem)
		 {
			DonationItem emp = ditemService.addDonationItem(donationItem);
			return new ResponseEntity<DonationItem>(emp, HttpStatus.CREATED);
		}
		
		//get all items
		@GetMapping("/items/get")
		public ResponseEntity<List<DonationItem>> getDonationItems() {
			List<DonationItem> lcl = ditemService.getDonationItems();
			ResponseEntity<List<DonationItem>> re = new ResponseEntity<List<DonationItem>>(lcl, HttpStatus.OK);
			return re;
		}
		
		//get  item by id
		@GetMapping("/items/donated/{itemId}")
		public ResponseEntity<DonationItem> getdonationItemById(@PathVariable int itemId) {
			DonationItem lcl = ditemService.getdonationItemById(itemId);
			ResponseEntity<DonationItem> re = new ResponseEntity<DonationItem>(lcl, HttpStatus.OK);
			return re;
		}
		
		//update item
		@PutMapping(path = "/item/update/{itemId}")
		public ResponseEntity<DonationItem> updateDonationItem(@PathVariable("itemId") int itemId,@RequestBody DonationItem donationItem)   {
			DonationItem e1 = ditemService.updateDonationItem(itemId,donationItem);

			ResponseEntity<DonationItem> re = new ResponseEntity<DonationItem>(e1, HttpStatus.OK);
			return re;
		}
		
		//delete item details
		@DeleteMapping(path = "/item/remove/{itemId}")
		public ResponseEntity<DonationItem> removeDonationItem(@PathVariable int itemId) throws NoSuchEmployeeException {
			DonationItem d =ditemService.removeDonationItem(itemId);

			ResponseEntity<DonationItem> re = new ResponseEntity<DonationItem>(HttpStatus.OK);
			return re;
		}
		
		
		
		
}
