package com.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.model.DonationBox;

@Repository
public interface DonationBoxRepository extends JpaRepositoryImplementation<DonationBox, Integer> {

}
