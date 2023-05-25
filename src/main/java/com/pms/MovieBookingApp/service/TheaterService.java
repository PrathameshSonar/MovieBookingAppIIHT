package com.pms.MovieBookingApp.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pms.MovieBookingApp.repository.TheaterRepo;

@Service
public class TheaterService {
	
	@Autowired
	private TheaterRepo theaterRepo;
		
	public ResponseEntity<Map<String, Boolean>> deleteTheater(String theaterName) {
		theaterRepo.deleteById(theaterName);
		
		Map<String, Boolean> response = new HashMap<>();

		response.put("Theater deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);

	}

	
	
}
