package com.optum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;
import com.optum.model.*;
import com.optum.model.Hospital;
import com.optum.model.custom.*;

public interface Hospitalrepo extends JpaRepository<Hospital, Long>{

	//counting total no of doctors assign in one hospital
	
	/*SELECT books.*, count(orders.book_id) as number_of_orders        
from books
left join orders
on (books.book_id = orders.book_id)
group by
    books.book_id*/
	//insert into  hospital values(total_doctors)( 
//	@Query( value = "(select count(doctor.doctor_id)"
//			+ "from hospital left join doctor"
//			+ " on(hospital.hospital_id = doctor.hospital_id) "
//			+ "group by hospital.hospital_id )"
//			+ "having hospital.hospital_id=:hospital_id " 
//			, nativeQuery =true)
//	int countTotalDoctorInHospital(@Param("hospital_id") Long hospital_id);
	
	
	@Query( value = "select count(hospital_id) as number_of_doctors " + 
			"from doctor " + 
			"group by hospital_id " + 
			"having hospital_id=:hospital_id " 
			, nativeQuery =true)
	int countTotalDoctorInHospital(@Param("hospital_id") Long hospital_id);
	
	
	
	//Collection<Hospital> countTotalDoctorInHospital(); 
	//interface -->totaldoctor count made customly to count the total numbe rof dcotor presnt 
	 //List<TotalDoctorCount> countTotalDoctorInHospital(); 



}
