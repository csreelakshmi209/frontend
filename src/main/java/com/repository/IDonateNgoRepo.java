package com.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.model.DonateToNgo;

@Repository
public interface IDonateNgoRepo extends JpaRepositoryImplementation<DonateToNgo, Integer> {

}
