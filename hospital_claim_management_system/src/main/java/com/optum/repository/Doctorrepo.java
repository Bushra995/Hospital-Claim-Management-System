package com.optum.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.optum.model.Doctor;
import java.util.List;

@Repository
public interface Doctorrepo  extends JpaRepository<Doctor, Long>{

   // List<Doctor> findByHospital(Long hospital_id);

    @Query("select dc from Doctor dc where dc.doctor_type.id = ?1")
    //.id is must to use for rfering to pk of table
    List<Doctor> findAllDoctors(long doctor_type);
    //List<Doctor> findAllByDoctor_Type(Long doctor_type);


    //list of all doctors by hospital id

    @Query("select dc from Doctor dc where dc.hospital_id.id = ?1")

    List<Doctor> findAllDoctorsByHospitalId(long hospital_id);


    @Query("select dc from Doctor dc where dc.doctor_total_price between 1 AND (select uc.user_insurance_money from User uc where uc.user_id.id= ?1)  AND dc.doctor_type.id= ?2 ")
    List<Doctor> findAllDoctorByUserPreference(long user_id , long doctor_type);
}

/*
* //  List<Doctor> findAllByHospital_id(long hospital_id);
public// List<Doctor> findByHospital(long hospital_id);

//@Transactional
//List<Doctor> findByHospital(long hospital);
*
* /*
* @Query("")
Stream<User> findAllByCustomQueryAndStream();*/

//public List<Doctor> doctors =
//    @Query("select doctor.doctor_name , doctor.doctor_id  , doctor.hospital_id from doctor left join hospital on doctor.hospital_id = hospital.hospital_id having doctor.hospital_id= :hospital_id" )
//
//    public List<Doctor> findallDoctor(long hospital_id);
//

