package com.optum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.optum.model.Doctor_role;

public interface Doctorrolerepo extends JpaRepository<Doctor_role, Long> {
	
	//role: class enity name and  Long : primary ke name , so by using repositoy we can savec hanes to adatabse

}
