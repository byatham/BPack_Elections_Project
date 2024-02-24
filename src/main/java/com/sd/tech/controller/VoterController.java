package com.sd.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sd.tech.model.VoterList;
import com.sd.tech.service.VoterService;

@RestController
@RequestMapping("/voter")
//@Scope("session")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class VoterController {
	public VoterController() {
	System.out.println("VoterController Object is creatred ::: ");
	}
	
	
	@Autowired
	private VoterService voterService;
	
	@PostMapping("/save")
	public String saveVoterData(@RequestBody VoterList voterList)
	{
		String saveVoter = voterService.saveVoter(voterList);
		return saveVoter;
	}

	
	@GetMapping("/getAll")
	public List<VoterList> getAllVotersData()
	{
		List<VoterList> list = voterService.getAllVotersData();
		return list;
		
	}


	@GetMapping("/caste")
	public List<VoterList> getByCasteVoterData(String caste, String subcaste)
	{
		List<VoterList> list = voterService.getByCasteAndSubCaste(caste, subcaste);
		return list;
		
	}
	

	@GetMapping("/address")
	public List<VoterList> getByAddress(String address)
	{
		List<VoterList> list = voterService.getByAddress(address);
		return list;
		
	}
	
	
	@GetMapping("/casteByAge")
	public List<VoterList> getByAgeAndCaste(int age,String caste)
	{
		List<VoterList> list = voterService.getByAgeCaste(age, caste);
		return list;
		
	}
	

	@GetMapping("/genderByAge")
	public List<VoterList> getByAgeAndGender(int age,String gender)
	{
		List<VoterList> list = voterService.getByAgeGender(age, gender);
		return list;
		
	}
}
