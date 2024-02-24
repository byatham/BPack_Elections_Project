package com.sd.tech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.tech.model.VoterList;
import com.sd.tech.repo.VoterRepository;

@Service
public class VoterServiceImpl implements VoterService{
	
	@Autowired
	private VoterRepository voterRepository;
	
	public String saveVoter(VoterList voterList)
	{
		VoterList save = voterRepository.save(voterList);
		if(save!=null)
		{
			return "data is saved in DB successfully";
		}
		else
		{
			return "data is not able to saved in DB successfully";

		}
	}
	
	public List< VoterList> getAllVotersData()
	{
		List<VoterList> list = voterRepository.findAll();
		return list;
	}

	@Override
	public List<VoterList> getByCasteAndSubCaste(String caste, String subcaste) {
		
		return voterRepository.findByCasteAndSubCaste(caste, subcaste);
	}

	@Override
	public List<VoterList> getByAddress(String address) {
		
		return voterRepository.findByAddress(address);
	}

	@Override
	public List<VoterList> getByAgeCaste(int age, String caste) {
		
		return voterRepository.getByAgeCaste(age, caste);
	}

	@Override
	public List<VoterList> getByAgeGender(int age, String gender) {
		return voterRepository.getByAgeGender(age, gender); 
	}

} 
