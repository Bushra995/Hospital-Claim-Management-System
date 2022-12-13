package com.optum.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="inusurance_claimed")
public class Insurance_claimed {

	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long insurance_claim_id;

private String insurance_claim_type_name; //from html options

private int insurance_claim_money; //total money nput text 


//many to one
@ManyToOne(fetch = FetchType.LAZY)
private User user;


public long getInsurance_claim_id() {
	return insurance_claim_id;
}


public void setInsurance_claim_id(long insurance_claim_id) {
	this.insurance_claim_id = insurance_claim_id;
}


public String getInsurance_claim_type_name() {
	return insurance_claim_type_name;
}


public void setInsurance_claim_type_name(String insurance_claim_type_name) {
	this.insurance_claim_type_name = insurance_claim_type_name;
}


public int getInsurance_claim_money() {
	return insurance_claim_money;
}


public void setInsurance_claim_money(int insurance_claim_money) {
	this.insurance_claim_money = insurance_claim_money;
}


public User getUser() {
	return user;
}


public void setUser(User user) {
	this.user = user;
}

}
