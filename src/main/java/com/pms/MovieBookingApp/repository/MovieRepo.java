package com.pms.MovieBookingApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pms.MovieBookingApp.model.Movie;
import com.pms.MovieBookingApp.model.Movie.MovieId;

public interface MovieRepo extends MongoRepository<Movie, MovieId> {

	

}
