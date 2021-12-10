package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Donation;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Integer> {

//	 @Query(value="select donor_username,donor_password from donor",nativeQuery = true)
//	 String checkLoginDetails(String username,String password);
//	 @Query("select donor_email from donor")
//	Optional<Donor> findUserExists(@Param("d") Donor d);
}
