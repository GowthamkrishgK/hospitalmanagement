package com.project.demo.service;

import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.demo.model.*;

import com.project.demo.repository.*;
import com.project.demo.requests.DoctorRequest;


@Service
public class DoctorService {
@Autowired
private DoctorRepository doctorrepository;
@Autowired
private UsrRepository user;
@Value("${app.doctor.role}")
private String doctorrole;
@Autowired
private PasswordEncoder encoder;


@Transactional
public void saveDoctor(DoctorRequest doctor) {
	Doctor d=doctor.toDoctor();
	d=doctorrepository.save(d);
	User u=new User();
	u.setDoctor(d);
	u.setAuthorities(doctorrole);
	u.setUsername(d.getEmail());
	u.setPassword(doctor.getPassword());
	u=user.save(u);
	d.setUser(u);
	d=doctorrepository.save(d);
	
	
}
public List<Doctor> saveDoctors(List<Doctor> doctors){
	return doctorrepository.saveAll(doctors);
}
public Doctor  docbyName(String name){
	return doctorrepository.findbyName(name);
}
public Doctor  docbyemail(String email){
	return doctorrepository.findbyEmail(email);
}
public List<Doctor> getDoctors(){
	return doctorrepository.findAll();
}
public String deleteDoctor(int doc_id) {
	doctorrepository.deleteById(doc_id);
	return "Doctor Removed "+doc_id;
}
public Doctor updateDoctor(DoctorRequest doctor) {
	

	Doctor existingDoctor=doctor.toDoctor();
	return doctorrepository.save(existingDoctor);
}

public User forgotPassword(String email,String pass) throws Exception {  
	   User d=user.findbyname(email);
	   d.setPassword(pass);
  
  return user.save(d);
  
	
}
public String DeleteDoctorusingEmail(String email)throws Exception {
	 if(email!=null) {
		Doctor d= doctorrepository.findbyEmail(email);
		doctorrepository.deleteDoctorbyemail(email);
		return " "+d.getName()+"deleted";
	 }else {
		 throw new Exception("Doctor with Email "+email+"does not found");
		
	 }
	 
	 
}
}
