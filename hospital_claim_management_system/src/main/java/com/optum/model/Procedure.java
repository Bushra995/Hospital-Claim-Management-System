package com.optum.model;

import javax.persistence.Column;
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

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "appointment")
public class Procedure {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private long procedure_id;
	
	@Column(name = "diagnosis_type")
	private String diagnosis_type;


	@Column(name="fees")
	private int fees;
	//doctor id  :fk
	//and user id :fk
	//total cost 
	//user_role  will take one user only : as one user can have multiple roles
		
		
		@ManyToOne(fetch = FetchType.EAGER)
//		@JoinTable( name=)
		//@JoinColumn(name= "user_id" , nullable = false ) // , referencedColumnName = "hospital_id")
	   
		//if we fetch user roles so its user will b also get fetch automatically from db
		private User user; //here User: classname //from user class //it wil store user id from user class
	   @ManyToOne
		private Doctor doctor; //it will store roleid from role class
	
	   //onse user can have 1 doctor , or more , or many doctor cn have one or more user
	   //sp there m to n relztionship b user nd doctro 
	   
	
	
	

}
