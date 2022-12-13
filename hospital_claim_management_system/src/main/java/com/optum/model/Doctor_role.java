package com.optum.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//doctor role
@Entity
@Table(name="doctor_role")
public class Doctor_role {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "doctor_type")
	private long doctor_type;
	

	private String doctor_specialist;
	
//	@OneToOne(mappedBy = "doctor_type")
//	//@OneToOne(mappedBy = "doctor_role")
//	//@JoinColumn(name = "doctor_type"): we wont use join column in refered table
//	//@JoinColumn(name = "doctor_type" , referencedColumnName = "doctor_type")
//	private Doctor doctor;

	public long getDoctor_type() {
		return doctor_type;
	}

	public void setDoctor_type(long doctor_type) {
		this.doctor_type = doctor_type;
	}

	public String getDoctor_specialist() {
		return doctor_specialist;
	}

	public void setDoctor_specialist(String doctor_specialist) {
		this.doctor_specialist = doctor_specialist;
	}

//	public Doctor getDoctor() {
//		return doctor;
//	}
//
//	public void setDoctor(Doctor doctor) {
//		this.doctor = doctor;
//	}

	public Doctor_role(long doctor_type, String doctor_specialist /*,Doctor doctor*/) {
		super();
		this.doctor_type = doctor_type;
		this.doctor_specialist = doctor_specialist;
		//this.doctor = doctor;
	}
	
	public Doctor_role() {}

}
