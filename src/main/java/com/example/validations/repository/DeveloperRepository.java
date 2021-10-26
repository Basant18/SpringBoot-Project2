package com.example.validations.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.validations.entity.Developer;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer,Long>{
	
	List<Developer> findBydevId(Long devId);

}
