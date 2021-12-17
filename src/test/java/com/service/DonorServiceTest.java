package com.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.SQLException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.exception.DuplicateDonorException;
import com.exception.NoSuchDonorException;
import com.model.Address;
import com.model.Donation;
import com.model.DonationItem;
import com.model.Donor;
import com.repository.DonationRepository;
import com.repository.DonorRepository;

@SpringBootTest
class DonorServiceTest {
	@MockBean
	DonorRepository donorRepository;

	@MockBean
	DonationRepository donationRepository;

	@Autowired
	IDonorService donorService;

	// test case to register the donor
	@Test
	void registerDonor() throws DuplicateDonorException, SQLException {
		Donor d = new Donor();
		d.setDonorId(1);
		d.setDonorName("Mayur");
		d.setDonorEmail("abc@gmail.com");
		d.setDonorPhone("7541239852");
		d.setDonorUsername("Mayur");
		d.setDonorPassword("456873");
		Address a = new Address();
		a.setAddressId(1);
		a.setCity("Noida");
		a.setState("Delhi");
		a.setLandmark("");
		a.setPin("121002");
		d.setAddress(a);
		Mockito.when(donorRepository.save(d)).thenReturn(d);
		assertThat(donorService.registerDonor(d)).isEqualTo(d);
	}

	// test case to donor login
	@Test
	void login() throws NoSuchDonorException {
		Donor donor = new Donor();
		donor.setDonorId(1);
		donor.setDonorUsername("Mayur");
		donor.setDonorPassword("456873");
		Optional<Donor> d2 = Optional.of(donor);

		Mockito.when(donorRepository.findById(1)).thenReturn(d2);

		assertThat(donorService.login(donor)).isEqualTo(donor);
	}

	// test case to donote to NGO
	@Test
	void donateToNGO() {
		Donation dn = new Donation();
		dn.setDonationId(101);
		dn.setDonationAmount(50000);
		DonationItem di = new DonationItem();
		di.setdItemId(1);
		di.setItemDescription("cloth");
		dn.setItem(di);
		Mockito.when(donationRepository.save(dn)).thenReturn(dn);
		assertThat(donorService.donateToNGO(dn)).isEqualTo(dn);
	}

}