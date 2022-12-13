package com.optum.model;

import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.optum.*;
@Entity
@Table(name = "User")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ) 
	private long user_id;
	@Column(name="user_name")
	private String user_name;
	@Column(name = "user_age")
	private int user_age;
	@Column(name = "user_insurance_type")
	private String user_insurance_type;
	@Column(name = "user_insurance_money")
	private int user_insurance_money;
//	private int user_claim_money;
	@Column(name="user_password")
	private String user_password;
	//insurance cliam fk 
	
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getUser_age() {
		return user_age;
	}
	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}
	public String getUser_insurance_type() {
		return user_insurance_type;
	}
	public void setUser_insurance_type(String user_insurance_type) {
		this.user_insurance_type = user_insurance_type;
	}
	public int getUser_insurance_money() {
		return user_insurance_money;
	}
	public void setUser_insurance_money(int user_insurance_money) {
		this.user_insurance_money = user_insurance_money;
	}
	
	//genrate constrctor 
	
	public User(long user_id, String user_name, int user_age, String user_insurance_type, int user_insurance_money) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_age = user_age;
		this.user_insurance_type = user_insurance_type;
		this.user_insurance_money = user_insurance_money;
	}
	public User() {
		
	}
	
	//one to many relatiosnhip in user and isnurance claimed
	
	
	 @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true) 
	 private Set<Insurance_claimed> total_insurance_claimed = new HashSet();
	 
	 public void addClaim(Insurance_claimed insurance_claimed){
	        total_insurance_claimed.add(insurance_claimed);
	        insurance_claimed.setUser(this);
	    }
	 //calling from insuarnce claimed class 
	    public void removeClaim(Insurance_claimed insurance_claimed){
	        total_insurance_claimed.remove(insurance_claimed);
	        insurance_claimed.setUser(null);
	    }
		
	    
	    
	    //1 user 1 doctor , 1 user many doctor user--prcedure dctor 
//1 user many procedure 
		@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER , mappedBy = "user")
		@JsonIgnore
		private Set<Procedure> doctor_assigned_set = new HashSet<Procedure>();
		//fetchtypelazy: when we ftech role so  if instant user role won't  come 
		
		
	  }
