package com.example.validations.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.validations.entity.DeveloperAddress;

@Repository
public interface DeveloperAddressRepository extends JpaRepository<DeveloperAddress,Long>{

	//List<DeveloperAddress>  findBydevId(Long devId);
	
}
