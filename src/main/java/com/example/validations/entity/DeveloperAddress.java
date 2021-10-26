package com.example.validations.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="DEV_ADDRESS",schema="hr")
public class DeveloperAddress {

	@Id
	@Column(name="S_NO")
	@SequenceGenerator(name = "DeveloperAddress", sequenceName = "DEVADRESS_SEQ",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="DeveloperAddress")
	Long sNo;
	
	public Long getsNo() {
		return sNo;
	}

	public void setsNo(Long sNo) {
		this.sNo = sNo;
	}

//	@Column(name="DEVELOPER_ID",insertable=false update="false")
//	@NotNull(message="Developer ID is mandatory")
//	Long devId;
//	
//	public Long getDevId() {
//		return devId;
//	}
//
//	public void setDevId(Long devId) {
//		this.devId = devId;
//	}

	@Column(name="DEVELOPER_STATE")
	@NotEmpty(message="Developer State is mandatory")
	String devState;
	
	@Column(name="DEVELOPER_COUNTRY")
	@NotEmpty(message="Developer Country is mandatory")
	String devCountry;

	public String getDevState() {
		return devState;
	}

	public void setDevState(String devState) {
		this.devState = devState;
	}

	public String getDevCountry() {
		return devCountry;
	}

	public void setDevCountry(String devCountry) {
		this.devCountry = devCountry;
	}
	
//	@JsonManagedReference
//	@JsonIgnore
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
	//@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name="DEVELOPER_ID")
	private Developer dev = new Developer();

	public Developer getDev() {
		return dev;
	}

	public void setDev(Developer dev) {
		this.dev = dev;
	}
}
