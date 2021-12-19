package com.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.NoSuchNeedyPeopleException;
import com.model.NeedyPeople;
import com.service.NeedypeopleServiceImpl;

@RestController
@RequestMapping("/needyPeople")
public class NeedyPeopleController {

	@Autowired
	NeedypeopleServiceImpl needyImpl;
	
	
	//register needy person
	@PostMapping("/add")
    public  ResponseEntity<NeedyPeople> registerNeedyPerson(@Valid @RequestBody NeedyPeople person) throws NoSuchNeedyPeopleException{
        
        NeedyPeople p = needyImpl.registerNeedyPerson(person);
        return new ResponseEntity<NeedyPeople>(person,HttpStatus.CREATED);
    }
}