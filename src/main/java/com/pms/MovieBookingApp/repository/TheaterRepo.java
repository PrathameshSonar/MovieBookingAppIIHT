package com.pms.MovieBookingApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pms.MovieBookingApp.model.Theater;

public interface TheaterRepo extends MongoRepository<Theater, String> {

}
