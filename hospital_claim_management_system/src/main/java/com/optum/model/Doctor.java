package com.optum.model;

import java.util.*;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name= "doctor")
public class Doctor {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="doctor_id")
	private long doctor_id;


	@Column(name="doctor_name" , length = 100)
	private String doctor_name;
	
	@Column(name = "doctor_total_price")
	private int doctor_total_price;

//	@Column(name = "doctor_type")
//	private long doctor_type;

	@Column(name="password")
	private String password;

	@ManyToOne(fetch = FetchType.LAZY , optional=false )
	@JoinColumn(name= "hospital_id" , referencedColumnName = "hospital_id",nullable = false ) // , referencedColumnName = "hospital_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Hospital hospital_id;

	//ONE HOSPITAL MANY DOCTORS
//	@OneToOne( cascade =  CascadeType.ALL )
	@ManyToOne(fetch = FetchType.LAZY , optional = false)
	@JoinColumn(name = "doctor_type", referencedColumnName="doctor_type" , nullable = false )
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Doctor_role doctor_type;

	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "doctor")//:as one user can have mutilple roles
	private Set<Procedure> Patientsassignset= new HashSet<Procedure>(); //here User_Role is class name
	
	public Doctor() {}

	public long getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(long doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public int getDoctor_total_price() {
		return doctor_total_price;
	}

	public void setDoctor_total_price(int doctor_total_price) {
		this.doctor_total_price = doctor_total_price;
	}

	public Hospital getHospital_id() {
		return hospital_id;
	}

	public void setHospital_id(Hospital hospital_id) {
		this.hospital_id = hospital_id;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Doctor_role getDoctor_type() {
		return doctor_type;
	}

	public void setDoctor_type(Doctor_role doctor_type) {
		this.doctor_type = doctor_type;
	}

	public Set<Procedure> getPatientsassignset() {
		return Patientsassignset;
	}

	public void setPatientsassignset(Set<Procedure> patientsassignset) {
		Patientsassignset = patientsassignset;
	}

	//co strctir using fields
	public Doctor(long doctor_id, String doctor_name, int doctor_total_price, Hospital hospital_id,
				  Doctor_role doctor_type, Set<Procedure> patientsassignset) {
		super();
		this.doctor_id = doctor_id;
		this.doctor_name = doctor_name;
		this.doctor_total_price = doctor_total_price;
		this.hospital_id = hospital_id;
		this.doctor_type = doctor_type;
		Patientsassignset = patientsassignset;
	}
}
