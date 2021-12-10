package com.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.repository.NeedyPeopleRepository;
import com.exception.NoSuchDonorException;
import com.exception.NoSuchNeedyPeopleException;
import com.model.Address;
import com.model.Donor;
import com.model.NeedyPeople;

@SpringBootTest
class NeedyPeopleTest {

	@MockBean
	NeedyPeopleRepository needyRepo;

	@Autowired
	INeedyPeopleService needyService;

	// test case to register needy people
	@Test
	void testRegisterNeedyPerson() throws NoSuchNeedyPeopleException {
		NeedyPeople p = new NeedyPeople();
		p.setNeedyPersonId(1);
		p.setNeedyPersonName("mamatha");
		p.setPhone("345678");
		p.setFamilyIncome(5000);
		p.setAddress(null);
		Address a = new Address();
		a.setAddressId(1);
		a.setCity("Noida");
		a.setState("Delhi");
		a.setLandmark("");
		a.setPin("121002");
		p.setAddress(a);
		Mockito.when(needyRepo.save(p)).thenReturn(p);
		assertThat(needyService.registerNeedyPerson(p)).isEqualTo(p);

	}

	// test case for needy people login
	@Test
	void login() throws NoSuchDonorException, NoSuchNeedyPeopleException {
		NeedyPeople needy = new NeedyPeople();
		needy.setNeedyPersonId(1);
		needy.setNeedyPersonName("mamatha");
		needy.setPhone("345678");
		needy.setFamilyIncome(5000);
		needy.setAddress(null);
		Address a = new Address();
		a.setAddressId(1);
		a.setCity("bangalore");
		a.setState("Karnataka");
		a.setLandmark("");
		a.setPin("121002");
		needy.setAddress(a);
		Optional<NeedyPeople> n = Optional.of(needy);

		Mockito.when(needyRepo.findById(1)).thenReturn(n);

		assertThat(needyService.login(needy)).isEqualTo(needy);
	}
}