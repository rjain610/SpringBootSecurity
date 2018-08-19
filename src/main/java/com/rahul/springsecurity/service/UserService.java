package com.rahul.springsecurity.service;

import java.util.List;

import javax.transaction.Transactional;

import com.rahul.springsecurity.entity.Users;

public interface UserService {
	
	@Transactional
	List<Users> getAllUsers();

}
