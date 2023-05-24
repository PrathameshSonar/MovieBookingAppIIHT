package com.pms.MovieBookingApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pms.MovieBookingApp.model.User;

public interface UserRepo extends MongoRepository<User, Integer> {
	
	public User findByEmail(String email);
}
