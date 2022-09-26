package com.project.demo.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.project.demo.model.*;

import com.project.demo.repository.*;
import com.project.demo.requests.PrescribeRequest;
import com.project.demo.repository.DoctorPrescriptionRepository;
import com.project.demo.repository.DoctorRepository;
import com.project.demo.repository.UserAppointmentRepository;

@Service
public class DoctorPrescriptionService {
@Autowired
private DoctorPrescriptionRepository prescription;
@Autowired
private UserAppointmentRepository appointmentrepo;
@Autowired
private DoctorRepository doctorRepo;


public UserAppointment addprescription(PrescribeRequest prescript) {
	  DoctorPrescription pres= prescript.toPrescription();
	  String patientname=prescript.getPatientname();
	  String doctorname=prescript.getDoctorname();
	  Doctor d=null;
	  UserAppointment a=null;
	  if(patientname!=null && doctorname!=null) {
	           d=doctorRepo.findbyName(doctorname);
	           a=appointmentrepo.findbyname(patientname);
	  }
	  
	           pres.setDoctor(d);
	          
	           pres.setIsAvailable(true);
	           if(a!=null) {
	           pres.setPatient(a);
	           a.setP(pres);
	           prescription.save(pres);
	           
	           }
	           return  appointmentrepo.save(a);
	 
}
public DoctorPrescription getprPrescriptionbyid(int id) {
	return prescription.findById(id).orElse(null);
}
public List<DoctorPrescription> getprPrescriptions(){
	return prescription.findAll();
}

public String deleteDoctorPrescription(int id) {
	prescription.deleteById(id);
	return "DoctorPrescription Removed "+id;
}

public DoctorPrescription viewPrescription(String name) {
	
	return prescription.findbyPatientname(name);
}
}
