package com.optum.controller;

import java.util.List;

import com.optum.repository.Doctorrepo;
import com.optum.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.optum.serviceImpl.UserServiceImplementation;
import com.optum.repository.Hospitalrepo;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserServiceImplementation userService;
	
	@Autowired
	private Hospitalrepo hospitalrepo;

	@Autowired
	private Doctorrepo doctorrepo;


	@GetMapping("/")
    String return1(){
        return "Hello---World";
    }
	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
		
		return this.userService.create_user(user);
	}
	
	@GetMapping("/{userid}")
	public User getUser(@PathVariable("userid") Long userid) {
		return this.userService.getUser(userid);
	}
	
	@DeleteMapping("/{userid}")
	public String deleteUser(@PathVariable("userid") Long userid) {
		this.userService.deleteUser(userid);
		return "User with id= "+userid+" deleted succesfully !";
	}
	
	@PutMapping("/{userid}")
	public User updateUser(@RequestBody User user , @PathVariable("userid") Long userid) {
		
		return this.userService.updateUser(user, userid);
		//return user;
	}
	
	//creating mutliple users
	@PostMapping("/create/users")
	public String createMultipleUser(@RequestBody List<User> users) {
		this.userService.creatMultipleUser(users);
		return "Total User registered : "+users.size();
	}
	
	//hospital adding ttie up : fields requird are name sand state
	@PostMapping("/hospital")
	public Hospital addHospital(@RequestBody Hospital hospital)
	{
	
		return userService.addHospital(hospital);
	}
	
	@DeleteMapping("hospital/delete/{hospital_id}")
	public String DeleteHospital(@PathVariable("hospital_id") Long hospital_id) {
		return userService.deletehospital(hospital_id);
	}
//
	/*@DeleteMapping("/{userid}")
	public String deleteUser(@PathVariable("userid") Long userid) {
		this.userService.deleteUser(userid);
		return "User with id= "+userid+" deleted succesfully !";
	}*/
	@GetMapping("/hospital/{hospital_id}")
   public String getTotalDoctor( @PathVariable("hospital_id") Long hospital_id) {
		//
	//  userService.TotalDoctorinHospital(hospital_id);
	  try {
		//return "Total Number of Doctors : "+ hospitalrepo.countTotalDoctorInHospital(hospital_id);
		  return "Total number of Doctors : "+userService.TotalDoctorinHospital(hospital_id);
		
	  }
	  catch (Exception e) {
		// TODO: handle exception
		  return "Exception by bushra "+e;
	}
//	return "Total Number of doctors : "+ total_doctor;
	}


	//get all doctors

//	@GetMapping("/all/hospital")
//	public List<Hospital> getAllHospital(){
//		return hospitalrepo.findAll();
//	}
//

	//list of  all pateints
	@GetMapping("/users")
	public List<User> ListofAllpateints(){
	 return 	userService.listUser();
	}

	//list all doctor by their type


	//list all doctor by their type:error
	/*@GetMapping("/doctor/{doctor_type}")
	public List<Doctor> getallDoctorByType(@PathVariable( value= "doctor_type") Long doctor_type){

		return userService.getAllDoctorByType(doctor_type);
	}*/
////get all claims by patients
//	@GetMapping("/claims/{patients}")
//	publi


	//get all  doctor by type
	@GetMapping("/getAllDoctorbyType/{doctor_type}")
	public List<Doctor> getAll(@PathVariable("doctor_type") Long doctor_type){
		return this.userService.findAllDoctors(doctor_type);
	}

	//GET LIst of all doctor by  hospital id
	@GetMapping("/getAllDoctorbyHospitalId/{hospital_id}") //
	public List<Doctor> getallDoctor(@PathVariable("hospital_id") Long hospital_id){
		return  this.userService.listDoctorByHospital_id(hospital_id);
	}

	//get all patients by doctor


  //find doctor for users :
	// select * from doctor where doctor_total_price between 1 AND 20000 AND doctor_type=500;

	@GetMapping("/FindDoctorForUser/{user_id}/{user_diag_type}")
	public List<Doctor> FindDoctorByUserPreference(@PathVariable("user_id") long user_id , @PathVariable("user_diag_type")  long user_diag_type){
		return this.userService.getAllDoctorByUserPreference(user_id ,user_diag_type);
	}



}
