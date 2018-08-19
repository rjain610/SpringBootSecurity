package com.rahul.springsecurity.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rahul.springsecurity.entity.Users;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@Autowired
	EntityManager em;

	@Override
	public List<Users> getAllUsers() {
		return em.createQuery("from Users").getResultList();
	}

}
