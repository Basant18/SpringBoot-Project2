package com.example.validations.pojo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.validations.validators.AgeGuardianValidator;

@AgeGuardianValidator(age = "age", guardian = "guardian")
public class ConditionalCustomValidation {
	
	@NotNull(message="Id cannot be NULL")
	Integer id;
	@NotEmpty(message="name cannot be NULL")
	String name;
	String age;
	String guardian;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGuardian() {
		return guardian;
	}
	public void setGuardian(String guardian) {
		this.guardian = guardian;
	}
}
