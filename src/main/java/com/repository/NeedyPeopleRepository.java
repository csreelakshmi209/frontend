package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.model.NeedyPeople;

@Repository
public interface NeedyPeopleRepository extends JpaRepository<NeedyPeople, Integer> {

	NeedyPeople findByNeedyPersonName(String name);

//	 @Query(value="Select phone from needy_people",nativeQuery = true)
//	 String checkIfNeedyAlreadyExists(String phone);
	

}