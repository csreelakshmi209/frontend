package com.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.model.Address;

public interface AddressRepository extends JpaRepositoryImplementation<Address, Integer> {

}
