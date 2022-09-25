package com.project.demo.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.demo.model.Doctor;
import com.project.demo.model.User;
//import com.project.demo.MyConfiguration;
import com.project.demo.model.Userdetails;
import com.project.demo.requests.userRequest;
import com.project.demo.service.DoctorService;
import com.project.demo.service.UserService;

@RestController
public class UserController {
	
	
	
	
	@Autowired
	private UserService serve;
	
@PostMapping("/user/signup")
public String registerUser(@RequestBody userRequest u) {
	serve.addUser(u);
	return  "Registered Successfully";
}
@PostMapping("/admin/user/adduser")
public String addUser(@RequestBody userRequest u) {
	serve.addUser(u);
	return  "user added";
}



@GetMapping("/admin/user/name")
public Userdetails getUser(@RequestParam( "name")String name) {
	
	return serve.finduserbyname(name);
	
}
@GetMapping("/user")
public Userdetails getUserbyName() {
	String name="";
	return serve.finduserbyname(name);
	
}


@PutMapping("/admin/user/update/{email}")
public String updateUser(@PathVariable("email")String email,@RequestBody  userRequest user) {
	user.setEmail(email);
	 serve.addUser(user);
	 return "user "+email+"updated";
}
@PutMapping("/user/update/forgotpassword/{password}")
public User updateuserpassword(@RequestParam("email")String email,@RequestParam("password")String password) throws Exception { 
	return serve.forgotPassword(email, password);
}
@DeleteMapping("/admin/user/delete/{name}")
public String deleteUser(@PathVariable("name")String name) {
      return serve.DeleteByName(name);
}
@PostMapping("/admin/user/addUsers")
public List<Userdetails> registerUsers(@RequestBody List<userRequest> u) {
	return  serve.addUsers(u);
}
@GetMapping("/admin/user/users")
public List<Userdetails> getUser() {
	
	return serve.getUsers();
	
}
}
