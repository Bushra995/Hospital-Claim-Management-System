package com.optum.service;
import java.util.*;

import org.springframework.web.bind.annotation.RequestBody;

import com.optum.model.*;
public interface UserService {
	//create user
	public User create_user(User user_obj );
	//to get a user 
	public User getUser(long id);

	public List<Doctor> findAllDoctors(long doctor_type);

	
	//list  of all user
	public List<User> listUser();
	public void deleteUser(long id);
	
   public User updateUser(User user ,long id );
   public String creatMultipleUser(List<User> userslist );
   public Hospital addHospital(Hospital hospital);
//////
//   public int TotalDoctorinHospital(Hospital_Total_Emp hospital_Total_Emp ,long hospitalid);
   //public Hospital_Total_Emp create_TotalDoctUser(Hospital hospital);
   public int TotalDoctorinHospital(long hospitalid);
   
   //delte hospital
   
  public String   deletehospital(long hospital_id);
  //find by doctor_type
  public List<Doctor> listDoctor(long hospitalid );
  //find by hospital_id
  List<Doctor> listDoctorByHospital_id(long hospital_id);
  //public  List<User> listUser();
	public List<Doctor> getAllDoctorByUserPreference(long user_id, long doctor_type);
}
