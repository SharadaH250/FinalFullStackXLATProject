package com.student.mypack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.student.mypack.service.UserService;


@RestController
public class UserController {
	
@Autowired
private UserService userservice;

@GetMapping("user/{username}/{password}")
@CrossOrigin(origins="http://localhost:4200")
public int UserLogin( @PathVariable("username") String username1, @PathVariable("password") String password1)
{
	int flag = userservice.loginValidation(username1, password1);
	if(flag==0)
	{
		return 0;
	}
	return flag;
	
}
	
	
}