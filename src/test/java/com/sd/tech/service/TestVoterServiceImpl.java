package com.sd.tech.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.sd.tech.repo.VoterRepository;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestVoterServiceImpl {
	
	@InjectMocks
	VoterServiceImpl serviceImpl;
	
	@Mock
	VoterRepository voterRepository;
	
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
	public void testSaveVoter()
	{
		when(voterRepository.save(data1)).thenReturn(data1);
		String savedVoter = serviceImpl.saveVoter(data1);
		assertEquals("data is saved in DB successfully", savedVoter);
	}
	
	@Test
	public void testGetAllVotersData()
	{
		when(voterRepository.findAll()).thenReturn(voter_data);
		 List<VoterList> allVotersData = serviceImpl.getAllVotersData();
		assertEquals(voter_data, allVotersData);
	}
	
	@Test
	public void testSaveVoterNull()
	{
		when(voterRepository.save(null)).thenReturn(null);
		String savedVoter = serviceImpl.saveVoter(null);
		assertEquals("data is not able to saved in DB successfully", savedVoter);
	}
	
	@Test
	public void testGetByCasteAndSubCaste()
	{
		when(voterRepository.findByCasteAndSubCaste("BC", "Yadav")).thenReturn(voter_data);
		 List<VoterList> casteAndSubCasteData = serviceImpl.getByCasteAndSubCaste("BC", "Yadav");
		assertEquals(voter_data, casteAndSubCasteData);
	}
	
	@Test
	public void testGetByAddress()
	{
		when(voterRepository.findByAddress("Hyderabad")).thenReturn(voter_data);
		 List<VoterList> DataByAddress = serviceImpl.getByAddress("Hyderabad");
		assertEquals(voter_data, DataByAddress);
	}
	
	@Test
	public void testGetByAgeCaste()
	{
		when(voterRepository.getByAgeCaste(5, "BC")).thenReturn(voter_data);
		 List<VoterList> dataByAgeCaste = serviceImpl.getByAgeCaste(5, "BC");
		assertEquals(voter_data, dataByAgeCaste);
	}
	
	@Test
	public void testGetByAgeGender()
	{
		when(voterRepository.getByAgeGender(5, "Female")).thenReturn(voter_data);
		 List<VoterList> dataByAgeGender = serviceImpl.getByAgeGender(5, "Female");
		assertEquals(voter_data, dataByAgeGender);
	}

}
