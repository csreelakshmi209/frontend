package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.NoSuchDonorException;
import com.exception.NoSuchNeedyPeopleException;
import com.model.Donor;
import com.model.NeedyPeople;
import com.repository.NeedyPeopleRepository;

@Service
public class NeedypeopleServiceImpl implements INeedyPeopleService {

	// needy people services

	@Autowired
	NeedyPeopleRepository needyRepo;

	// register new needy peoples
	@Override
	public NeedyPeople registerNeedyPerson(NeedyPeople person) throws NoSuchNeedyPeopleException {
		NeedyPeople n = needyRepo.findById(person.getNeedyPersonId()).orElse(null);
		if (n != null) {
			throw new NoSuchNeedyPeopleException("User already exists for this id");
		} else {
			return needyRepo.save(person);
		}
	}

	// login needy people by entering required details
	@Override
	public NeedyPeople login(NeedyPeople person) throws NoSuchNeedyPeopleException, NoSuchDonorException {

		NeedyPeople needid = needyRepo.findById(person.getNeedyPersonId()).orElse(null);
		if (needid == null) {
			String NoSuchNeedyPeople = "No needy found by the needy id" + person.getNeedyPersonId();
			throw new NoSuchNeedyPeopleException("no such needy person");
		} else {
			if (person.getNeedyPersonName().equals(needid.getNeedyPersonName())
					&& person.getPhone().equals(needid.getPhone())) {
				return needid;
			} else {
				throw new NoSuchDonorException("Donor username and password are invalid");
			}
		}
	}

	// needy people can request for help
	@Override
	public boolean requestForHelp(NeedyPeople person) {
		System.out.println("send your request through mail box");
		return false;
	}

}