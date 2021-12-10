package com.service;

import org.springframework.stereotype.Service;

import com.exception.NoSuchDonorException;
import com.exception.NoSuchNeedyPeopleException;
import com.model.NeedyPeople;
@Service
public interface INeedyPeopleService {
	public NeedyPeople registerNeedyPerson(NeedyPeople person) throws NoSuchNeedyPeopleException;
	public NeedyPeople login(NeedyPeople person) throws NoSuchNeedyPeopleException, NoSuchDonorException;
	public boolean requestForHelp(NeedyPeople person);

}