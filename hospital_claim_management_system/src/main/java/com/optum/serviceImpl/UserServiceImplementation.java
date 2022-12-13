package com.optum.serviceImpl;
import java.util.*;
import com.optum.repository.*;
import com.optum.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optum.model.Hospital;

import com.optum.model.User;
import com.optum.repository.Hospitalrepo;
import com.optum.repository.Userrepo;
import com.optum.service.*;
@Service
public class UserServiceImplementation  implements UserService{
 
	//saving user  in an attribute
	@Autowired
	private Userrepo userrepo_obj;
	@Autowired
	private Hospitalrepo hospitalrepo;
	//making repo object of hospitalrepo to add
//	@Autowired
//	private Hospital_Total_Emp_repo hospital_total_repo_obj;
	//for doctor
	@Autowired
	private Doctorrepo doctorrepo;
	//now implementing its method create user implemtifng from usersrvice
	

	public User create_user(User user) {
		// TODO Auto generated method stub
	Optional<User>	local = this.userrepo_obj.findById(user.getUser_id());
		if(local!=null) {
			System.out.println("User already exist");
		}
		
			return userrepo_obj.save(user);
		
	}
	
	//craating mutiple users
public String creatMultipleUser(List<User> userslist ) {
		 userrepo_obj.saveAll(userslist);
		 return  ""+ userslist.size()+"Total User registered sucessfully ";
		
	}

	public User getUser(long id) {
		// TODO Auto-generated method stub
		User local= userrepo_obj.findById(id).get();
		return local;
	}

	//find all user
	public List<User> listUser() {
		// TODO Auto-generated method stub
		return (List<User>)
	            userrepo_obj.findAll();
	}

	public void deleteUser(long id) {
		// TODO Auto-generated method stub
	//	User local=this.userrepo_obj.findById(id);
		this.userrepo_obj.deleteById(id);

		
	}

	public User updateUser(User user, long id) {
		// TODO Auto-generated method stub
		 User userdetails=  this.userrepo_obj.findById(id).get();
		User updateduser;
		 
         if(userdetails ==null) {
        	 return null;
      	 //  System.out.println("Not exist");
         }
         
         else {
      	   User dbuser =userdetails;
      	  dbuser.setUser_age(user.getUser_age());
      	   dbuser.setUser_insurance_money(user.getUser_insurance_money());
      	   dbuser.setUser_insurance_type(user.getUser_insurance_type());
      	   dbuser.setUser_name(user.getUser_name());
      	   //saving upadted user
      	  updateduser =userrepo_obj.save(dbuser);
         }
       
       //  userrepo_obj.save(user);
        
       return  updateduser;
//		String username= user.getUser_name();
//	
//		//return this.userrepo_obj.findb
//	    return this.userrepo_obj.findByUsername(username);
//	    
      
	}

//add hospital adding
	public Hospital addHospital(Hospital hospital)
	{
		Optional<Hospital>	local_hospital = this.hospitalrepo.findById(hospital.getHospital_id());
		//findById(user.getUser_id());
		if(local_hospital!=null) {
			System.out.println("User already exist");
		}
		
		
	
			return hospitalrepo.save(hospital);
			
			
	}

//	public Hospital_Total_Emp create_TotalDoctUser(Hospital hospital) {
//		// TODO Auto-generated method stub
//	 Optional<Hospital> findhospitalbyid =this.hospitalrepo.findById(hospital.getHospital_id());
//		if(findhospitalbyid==null)
//		{
//			System.out.println("User not exist");
//		}
//		
//	}
//	

	//cpunt total number of cdcotor in a hospital and automatically saving to other table 

	public int TotalDoctorinHospital(long hospital_id) {


	   int 	total_emp= this.hospitalrepo.countTotalDoctorInHospital(hospital_id);
	   try {
		//Hospital_Total_Emp hospital_Total_Empp = new Hospital_Total_Emp();
		
	//	hospital_Total_Empp.setHospital_id(hospital_id);
	   //sving automatically to anothr table 
	   Hospital  hospital_details = this.hospitalrepo.findById(hospital_id).get();
	   hospital_details.setTotal_doc(total_emp);
	   hospitalrepo.save(hospital_details);
//
		}
	   catch (Exception e) {
		// TODO: handle exception
		   System.out.println(e+"Executed! ");
	}
		// return hospitalrepo.countTotalDoctorInHospital(hospital_id);
		return total_emp;
	}

public String deletehospital(long hospital_id) {
	// TODO Auto-generated method stub

	hospitalrepo.deleteById(hospital_id);
	//also delteing all dcotor assign to that particular hospital
	
	return "Hospital delted succesfully";
}

	@Override
	public List<Doctor> listDoctor(long hospitalid) {
		return null;
	}

	public List<Doctor> findAllDoctors(long doctor_type){
		return doctorrepo.findAllDoctors(doctor_type);
   }





	//find doctors  by hospital id , group doctpor on basis of sam hospital
	@Override
	public List<Doctor> listDoctorByHospital_id(long hospital_id) {
		return doctorrepo.findAllDoctorsByHospitalId(hospital_id);

	}

	@Override
	public List<Doctor> getAllDoctorByUserPreference(long user_id, long doctor_type) {

		return doctorrepo.findAllDoctorByUserPreference(user_id,doctor_type);

	}

	/*public  List<Doctor> getAllDoctorByType(long doctor_type){
		if(!hospitalrepo.existsById(doctor_type)){
			return null;
		}
		return  doctorrepo.findAllByDoctor_Type(doctor_type);

	}*/

}
