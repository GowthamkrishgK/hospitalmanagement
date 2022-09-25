package com.project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.UserAppointment;
import com.project.demo.requests.AppointmentRequest;
import com.project.demo.service.UserAppointmentService;

@RestController
public class AppointmentController {
	@Autowired
	private UserAppointmentService appservice;
@PostMapping("/user/appointment/{user}/book")
public UserAppointment book(@RequestBody AppointmentRequest req,@PathVariable("user")String user) {
	         return  appservice.addAppointment(req, user);
}
}
