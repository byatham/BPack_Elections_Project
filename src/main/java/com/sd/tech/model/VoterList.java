package com.sd.tech.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@Table(name="voter_data")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class VoterList {
	
	//Defining serialNumber as primary key  
	@Id  
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column 
	private int serialNumber;  
	@Column  
	private String name;  
	@Column  
	private String familyHead;  
	@Column  
	private String voterId;  
	@Column  
	private String mobileNumber;
	@Column  
	private String gender;  
	@Column  
	private String caste;  
	@Column  
	private String subCaste;  	
	@Column  
	private int age;  
	@Column  
	private int ward; 
	@Column  
	private int boothNumber; 
	
	@Column  
	private String address; 
	
}
