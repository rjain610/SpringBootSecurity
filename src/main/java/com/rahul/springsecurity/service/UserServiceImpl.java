package com.rahul.springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.springsecurity.entity.Users;
import com.rahul.springsecurity.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository ur;

	@Override
	public List<Users> getAllUsers() {
		return ur.getAllUsers();
	}

}
