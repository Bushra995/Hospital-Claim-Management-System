package com.optum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.optum.model.Insurance_claimed;

public interface Insurancerepo  extends JpaRepository<Insurance_claimed, Long>{

}
