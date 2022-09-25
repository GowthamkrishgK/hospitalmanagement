package com.project.demo.repository;

import java.util.Optional;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.project.demo.model.*;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	@Query("select d from Doctor d where d.name=?1")
      Doctor findbyName(String name);
	@Query("select d from Doctor d where d.email=?1")
    Doctor findbyEmail(String email);
	@Modifying
	@Transactional
	@Query("delete from Doctor d where d.email=?1")
	void deleteDoctorbyemail(String email);
}
