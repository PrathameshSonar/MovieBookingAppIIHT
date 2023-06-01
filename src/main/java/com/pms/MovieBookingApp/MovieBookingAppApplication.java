package com.pms.MovieBookingApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.pms.MovieBookingApp.model.Movie;
import com.pms.MovieBookingApp.repository.MovieRepo;
import com.pms.MovieBookingApp.repository.RoleRepo;

@SpringBootApplication
public class MovieBookingAppApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(MovieBookingAppApplication.class, args);
	}
	@Autowired
	private MovieRepo movieRepository;
	@Autowired
	private RoleRepo roleRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void run(String... args) throws Exception {
;

		
//		
//
//		Movie movie1 = new Movie("Dasara","Miraj",126,"Book ASAP");
//	 	Movie movie2 = new Movie("Bhoola","Miraj",122,"Book ASAP");
//	 	Movie movie3 = new Movie("Balagam","Konark",107,"Book ASAP");
//
//	 	movieRepository.saveAll(List.of(movie1,movie2,movie3));
//
//		Role admin = new Role(ERole.ROLE_ADMIN);
//		Role user = new Role(ERole.ROLE_USER);
//
//		roleRepository.saveAll(List.of(admin,user));
	}

}
