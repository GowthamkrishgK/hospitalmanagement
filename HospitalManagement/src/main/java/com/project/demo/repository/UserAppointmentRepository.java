package com.project.demo.repository;

import java.util.Optional;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.project.demo.model.*;

public interface UserAppointmentRepository extends JpaRepository<UserAppointment, String> {
	
	
	
	@Query("select u from UserAppointment u where u.Patientname=?1")
	  UserAppointment findbyname(String name);

	@Query("delete from UserAppointment u where u.Patientname=?1")
	void deleteAppointment(String name);
}
