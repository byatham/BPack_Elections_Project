package com.sd.tech.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sd.tech.model.VoterList;
import com.sd.tech.service.VoterService;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestVoterController {
	
	@InjectMocks
	VoterController  voterController;
	
	@Mock
	 VoterService voterService;
	
	List<VoterList> voter_data = new ArrayList<VoterList>();
	
	VoterList data1=new VoterList();
	
	@BeforeEach
	public void setUp()
	{
		MockitoAnnotations.openMocks(this);
	}
	
	@BeforeAll
	public void setUpOnce()
	{

		//List<VoterList> voter_data = new ArrayList<VoterList>();
		
		
		data1.setSerialNumber(1);
		data1.setName("Pavani Yatham");
		data1.setFamilyHead("Balaiah");
		data1.setVoterId("SUA12348");
		data1.setMobileNumber("9945757619");
		data1.setGender("Female");
		data1.setCaste("BC");
		data1.setSubCaste("Mudhiraj");
		data1.setAge(7);
		data1.setWard(10);
		data1.setBoothNumber(203);
		data1.setAddress("Hyderabad");
		
VoterList data2=new VoterList();
		
		data2.setSerialNumber(1);
		data2.setName("Akshitha Yatham");
		data2.setFamilyHead("Balaiah");
		data2.setVoterId("SUA12349");
		data2.setMobileNumber("9945757619");
		data2.setGender("Female");
		data2.setCaste("BC");
		data2.setSubCaste("Mudhiraj");
		data2.setAge(5);
		data2.setWard(10);
		data2.setBoothNumber(203);
		data2.setAddress("Hyderabad");
		
		voter_data.add(data1);
		voter_data.add(data2);
		
	}
	
	@Test
	public void testSaveVoterData()
	{
		when(voterService.saveVoter(data1)).thenReturn("Success");
		 String savedVoterData = voterController.saveVoterData(data1);
		assertEquals("Success", savedVoterData);
	}
	
	@Test
	public void testGetAllVotersData()
		{
		/*List<VoterList> voter_data1=java.util.Arrays.asList(
				
				new VoterList(1,"Pavani Yatham","Balaiah","SUA12348","9945757619","Female","BC","Mudhiraj", 7,10,203,"Hyderabad"),
				

				new VoterList(2,"Pavani Akshitha","Balaiah","SUA12349","9945757319","Female","BC","Mudhiraj", 5,10,203,"Hyderabad")
				);*/
		when(voterService.getAllVotersData()).thenReturn(voter_data);	
		
		 List<VoterList> allVotersData = voterController.getAllVotersData();
		assertEquals(voter_data,allVotersData);			
				
	}
	
	@Test
	public void testGetByAddress()
	{
		when(voterService.getByAddress  ("Hyderabad")).thenReturn(voter_data);
		List<VoterList> address = voterController.getByAddress("Hyderabad");
		assertEquals(voter_data, address);
	}
	
	

	@Test
	public void testGetByCasteVoterData()
	{
		when(voterService.getByCasteAndSubCaste("BC", "Mudhiraj")).thenReturn(voter_data);
		List<VoterList> casteAndSubcatse = voterController.getByCasteVoterData("BC", "Mudhiraj");
		assertEquals(voter_data, casteAndSubcatse);
	}
	
	@Test
	public void testGetByAgeAndCaste()
	{
		when(voterService.getByAgeCaste(5, "BC")).thenReturn(voter_data);
		List<VoterList> ageAndCatse = voterController.getByAgeAndCaste(5, "BC");
		assertEquals(voter_data, ageAndCatse);
	}
	
	@Test
	public void testGetByAgeAndGender()
	{
		when(voterService.getByAgeGender(5, "Male")).thenReturn(voter_data);
		List<VoterList> ageAndGender = voterController.getByAgeAndGender(5, "Male");
		assertEquals(voter_data, ageAndGender);
	}

}
