package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Donor;

public interface DonorRepository extends JpaRepository<Donor, Integer> {

	 @Query(value="Select donor_email from donor",nativeQuery = true)
	 String checkIfUserAlreadyExists(String donorEmail);

	 @Query("SELECT donor FROM Donor donor WHERE LOWER(donor.donorEmail) = LOWER(:donorEmail)")
	Donor findByEmailIdIgnoreCase(@Param("donorEmail") String donorEmail);

}
