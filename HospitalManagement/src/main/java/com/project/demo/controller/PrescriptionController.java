package com.project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.DoctorPrescription;
import com.project.demo.requests.PrescribeRequest;
import com.project.demo.service.DoctorPrescriptionService;

@RestController
public class PrescriptionController {
	@Autowired
	private DoctorPrescriptionService prescribeservice;
@PostMapping("/doctor/prescription/add")
public String addPrescription(@RequestBody PrescribeRequest pres) {
	
	 prescribeservice.addprescription(pres);
	 return "prescribed" +pres.getPatientname();
}
}
