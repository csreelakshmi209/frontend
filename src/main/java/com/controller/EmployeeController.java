package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.NeedyPeople;
import com.service.IEmployeeService;
import com.service.INeedyPeopleService;

@RestController
@RequestMapping(path="/needy")
public class EmployeeController {

	@Autowired
	IEmployeeService empService;
	
	@Autowired
	INeedyPeopleService needService;
	
	@PostMapping("/addNeedyPerson")
	public ResponseEntity<NeedyPeople> addNeedyPerson(@RequestBody NeedyPeople person) {
		NeedyPeople p=empService.addNeedyPerson(person);
		return new ResponseEntity<>(p,HttpStatus.CREATED);
	}
	
	@DeleteMapping(path="/deleteNeedyPerson")
	public ResponseEntity<String> deleteNeedyPerson(@RequestBody NeedyPeople person) {
		empService.removeNeedyPerson(person);
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getNeedyPeopleById/{id}")
	public ResponseEntity<NeedyPeople> getNeedyPeopleById(@PathVariable("id")  int id) {
		NeedyPeople p=empService.findNeedyPeopleById(id);
		return new ResponseEntity<NeedyPeople>(p, HttpStatus.OK);
	}
	
	@GetMapping(path = "/needyPeople/getByName/{name}")
	public ResponseEntity<NeedyPeople> findNeedyPeopleByName(@PathVariable("name") String name) {
		NeedyPeople n = empService.findNeedyPeopleByName(name);
		return new ResponseEntity<NeedyPeople>(n, HttpStatus.OK);
	}
	
	@GetMapping(path="/getAllNeedyPeople")
	public ResponseEntity<List<NeedyPeople>> getAllNeedyPeople() {
		return new ResponseEntity<List<NeedyPeople>>(empService.findAllNeedyPeople(), HttpStatus.OK);
	}
}