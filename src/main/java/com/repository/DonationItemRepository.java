package com.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.model.DonationItem;

@Repository
public interface DonationItemRepository extends JpaRepositoryImplementation<DonationItem, Integer> {

}
