package com.example.validations.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.validations.validators.AgeValidator;
import com.example.validations.validators.CreateDeveloper;
import com.example.validations.validators.EmailValidator;
import com.example.validations.validators.NumberValidator;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="DEVELOPERS", schema="HR")
public class Developer {
	
	@Id
	@SequenceGenerator(name = "Developer", sequenceName = "DEVELOPER_SEQ",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Developer")
	@Column(name="DEVELOPER_ID")
	private Long devId;
	
	@Column(name="DEVELOPER_NAME")
	@NotEmpty(groups=CreateDeveloper.class,message="Developer Name is mandatory")
	private String devName;
	
	@Column(name="AGE")
	//@NotNull(message="Age is mandatory")
	//@Min(value=18,message="must be equal or greater to 18")
	//@Max(value=45,message="must be equal or less than 45")
	@AgeValidator
	private Long age;
	
	@Column(name="EMAIL_ID")
	//@NotEmpty(groups=UpdateDeveloper.class,message="Developer Email ID is mandatory")
	@EmailValidator
	private String emailId;
	
	@Column(name="PHONE_NO")
	//@NotEmpty(message="Developer Phone No is mandatory")
	@NumberValidator
	private String phoneNo;
	
	@Column(name="SALARY")
	@NotNull(message="Salary is mandatory")
	@Min(value=1000,message="must be equal or greater to 1000")
	@Max(value=99999,message="must be less than or equal to 99999")
	private Float salary;
	
//	@Valid
//	@NotEmpty(message="Address is mandatory")
//	private List<DeveloperAddress> devAddress;
//	
//	public List<DeveloperAddress> getDevAddress() {
//		return devAddress;
//	}
//
//	public void setDevAddress(List<DeveloperAddress> devAddress) {
//		this.devAddress = devAddress;
//	}

	public Long getDevId() {
		return devId;
	}

	public void setDevId(Long devId) {
		this.devId = devId;
	}

	public String getDevName() {
		return devName;
	}

	public void setDevName(String devName) {
		this.devName = devName;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}
//	@JsonBackReference
//	@ManyToOne
//	@JoinColumn(name="DEVELOPER_ID")
//    private List<DeveloperAddress> devAddresses;
//
//	public List<DeveloperAddress> getDevAddresses() {
//		return devAddresses;
//	}
//
//	public void setDevAddresses(List<DeveloperAddress> devAddresses) {
//		this.devAddresses = devAddresses;
//	}
	@JsonManagedReference
	@OneToMany(mappedBy = "dev", cascade=CascadeType.ALL, orphanRemoval = true)
	@Valid
	private List<DeveloperAddress> developerAddress = new ArrayList<DeveloperAddress>();

	public List<DeveloperAddress> getDeveloperAddress() {
		return developerAddress;
	}

	public void setDeveloperAddress(List<DeveloperAddress> developerAddress) {
		this.developerAddress = developerAddress;
	}
	
}
