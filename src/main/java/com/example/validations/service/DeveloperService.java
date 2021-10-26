package com.example.validations.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.validations.entity.Developer;
import com.example.validations.entity.DeveloperAddress;
import com.example.validations.repository.DeveloperAddressRepository;
import com.example.validations.repository.DeveloperRepository;

@Service
public class DeveloperService {

	@Autowired
	private DeveloperRepository developerRepository;
	
	@Autowired 
	private DeveloperAddressRepository devAddressRepository;
	
	public List<Developer> getAllDevelopers()
	{
		return developerRepository.findAll();
	}

	public Developer createDeveloper(Developer developer) {
		
		return developerRepository.save(developer);
	}
	
	public ResponseEntity<Developer> updateDeveloper(long devId,Developer developer)
	{
//		Developer dev = developerRepository.findById(devId)
//				.orElseThrow(()->new Error("Developer ID does not exist"));
//		
//		dev.setDevName(developer.getDevName());
//		dev.setAge(developer.getAge());
//		dev.setEmailId(developer.getEmailId());
//		dev.setPhoneNo(developer.getPhoneNo());
//		dev.setSalary(developer.getSalary());
//		List<DeveloperAddress> devAdd = new ArrayList<DeveloperAddress>();
//		DeveloperAddress obj  = new DeveloperAddress();
//		List<DeveloperAddress> devAdd2 = developer.getDeveloperAddress();
//		for(DeveloperAddress d : devAdd2)
//		{
//			//DeveloperAddress da = devAddressRepository.findBysNo(null)
//			obj.setDevCountry(d.getDevCountry());
//			obj.setDevState(d.getDevState());
//			Long x = obj.getDev().getDevId();
//			if(x == devId)
//		}
//		devAdd.add(obj);
//		dev.setDeveloperAddress(devAdd);
		
		final Developer d = developerRepository.save(developer);
//		List<DeveloperAddress> daList = (List<DeveloperAddress>) developer.getDeveloperAddress();
//		
//		if(devId == daList.get(0).getDev().getDevId())
//		{
//			devAddressRepository.save(daList.get(0));
//		}
		
		return ResponseEntity.ok(d);
	}
	
	public String deleteDeveloper(Long devId)
	{
		developerRepository.deleteById(devId);
		return "deleted both parent and child";
	}
	
	public String deleteChildDeveloper(Long sNo)
	{
		devAddressRepository.deleteById(sNo);
		return "deleted child";
	}
}
