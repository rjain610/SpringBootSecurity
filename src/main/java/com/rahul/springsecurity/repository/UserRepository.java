package com.rahul.springsecurity.repository;

import java.util.List;

import com.rahul.springsecurity.entity.Users;

public interface UserRepository {
	
	public List<Users> getAllUsers();
}
