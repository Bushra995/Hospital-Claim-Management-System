package com.optum.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="hospital")
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ) //,  generator = "hospital_generator")
	@Column(name = "hospital_id")
	private long  hospital_id;
	
	@Column(name ="hospital_name")
	private String hospital_name;
	
	@Column(name="hospital_state")
	private String hospital_state;
	
	@Column(name="total_doctors")
	private int total_doc;   
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "hospital" , cascade = CascadeType.ALL)
//	
////	@JoinColumn(name = "hospital_id" , joinColumns = @JoinColumn(name ="") )
//	private List<Doctor> doctors = new ArrayList();
//	
	
	public Hospital() {}


	public long getHospital_id() {
		return hospital_id;
	}




	public String getHospital_name() {
		return hospital_name;
	}


	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}


	public String getHospital_state() {
		return hospital_state;
	}


	public void setHospital_state(String hospital_state) {
		this.hospital_state = hospital_state;
	}


	public int getTotal_doc() {
		return total_doc;
	}


	public void setTotal_doc(int total_doc) {
		this.total_doc = total_doc;
	}


//	public List<Doctor> getDoctors() {
//		return doctors;
//	}
//
//
//	public void setDoctors(List<Doctor> doctors) {
//		this.doctors = doctors;
//	}


	public Hospital(long hospital_id, String hospital_name, String hospital_state, int total_doc) { 
		//List<Doctor> doctors) {
		super();
		this.hospital_id = hospital_id;
		this.hospital_name = hospital_name;
		this.hospital_state = hospital_state;
		this.total_doc = total_doc;
		//this.doctors = doctors;
	}

	//para
	
	
	//one to one relationsjip btw hsopital and hospital_total_emp
//	
//	@OneToOne(cascade =CascadeType.ALL)
//	@JoinColumn(name = "hospital_id", referencedColumnName="hospital_id" )
//	private Hospital_Total_Emp hospital_Total_Emp;
//	

//	@OneToMany(mappedBy="hospital_id", cascade=CascadeType.ALL, orphanRemoval=true)
//	private List<Doctor> doctors;
//
}
