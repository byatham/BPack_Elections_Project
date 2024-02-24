package com.sd.tech.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sd.tech.model.VoterList;

import jakarta.transaction.Transactional;

@Repository
public interface VoterRepository  extends JpaRepository<VoterList, Integer>{
	
	List< VoterList> findByCasteAndSubCaste(String caste, String subcaste);
	
	List< VoterList> findByAddress(String address);

	@Transactional
	@Modifying
	@Query("SELECT v FROM VoterList v WHERE v.age > ?1 and v.caste = ?2")
	List< VoterList> getByAgeCaste(int age,String caste);
	
	@Transactional
	@Modifying
	@Query("SELECT v FROM VoterList v WHERE v.age > ?1 and v.gender = ?2")
	List< VoterList> getByAgeGender(int age,String gender);

}
