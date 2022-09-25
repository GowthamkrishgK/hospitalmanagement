package com.project.demo.service;

import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.model.*;

import com.project.demo.repository.*;
import com.project.demo.requests.AppointmentRequest;


@Service
public class UserAppointmentService {
@Autowired
private UserAppointmentRepository appointment;
@Autowired 
private DoctorPrescriptionRepository presrepo;
@Autowired
private DoctorRepository doctorrepo;
@Autowired
private UserRepository userrepo;
@Transactional
public UserAppointment addAppointment(AppointmentRequest apply,String name) {
	UserAppointment app=apply.toAppointment();
	Doctor d=doctorrepo.findbyName(apply.getDoctor());
	 app.setDoctor(d);
	 Userdetails u=userrepo.findbyname(name);
	 app.setUser(u);
	return appointment.save(app);
}
public List<UserAppointment> getAppointments(){
	return appointment.findAll();
}

public UserAppointment getAppointmentByUserName(String name){
	return appointment.findbyname(name);
	
}

//public User

public String DeleteAppointmentByname(String name) {
	appointment.deleteAppointment(name);
	return "Appointment Deleted "+name;
}

}
