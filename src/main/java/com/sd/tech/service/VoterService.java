package com.sd.tech.service;

import java.util.List;
import com.sd.tech.model.VoterList;

public interface VoterService {
	
	String saveVoter(VoterList voterList);
	List< VoterList> getAllVotersData();
	
	List< VoterList> getByCasteAndSubCaste(String caste, String subcaste);
	List< VoterList> getByAddress(String address);
	List< VoterList> getByAgeCaste(int age,String caste);
	List< VoterList> getByAgeGender(int age,String gender);

}