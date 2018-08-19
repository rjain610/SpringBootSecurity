package com.rahul.springsecurity.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.springsecurity.entity.Users;
import com.rahul.springsecurity.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService us;
	
	@GetMapping("/all")
	@ResponseBody
	public List<Users> getAllUsers() {
		return us.getAllUsers();
	}
}
