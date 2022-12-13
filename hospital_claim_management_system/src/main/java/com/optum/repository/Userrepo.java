package com.optum.repository;
import com.optum.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import com.optum.model.User;
public interface Userrepo  extends JpaRepository<User, Long>{
	

}
