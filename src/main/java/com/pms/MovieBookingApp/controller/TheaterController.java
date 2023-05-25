package com.pms.MovieBookingApp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.MovieBookingApp.model.Theater;
import com.pms.MovieBookingApp.repository.TheaterRepo;
import com.pms.MovieBookingApp.service.TheaterService;

@RestController
@RequestMapping("/theater")
public class TheaterController {

	@Autowired
	private TheaterService theaterService;

	@Autowired
	private TheaterRepo theaterRepo;

	@PostMapping("/add")
	public ResponseEntity<Theater> createTheater(@RequestBody Theater theater) {
		theaterRepo.save(theater);

		return new ResponseEntity<Theater>(theater, HttpStatus.CREATED);
	}

	@GetMapping("/theaterList")
	public ResponseEntity<List<Theater>> getTheaterList() {

		List<Theater> theaters = theaterRepo.findAll();
		return new ResponseEntity<List<Theater>>(theaters, HttpStatus.OK);
	}

	@DeleteMapping("/deleteTheater/{theaterId}")
	public ResponseEntity<Map<String, Boolean>> deleteTheater(@PathVariable String theaterName) {
		return theaterService.deleteTheater(theaterName);
	}

//	@PutMapping("/updateTheater/{theaterName}")
//	public Theater updateTheater(@RequestBody Theater theater, @PathVariable String theaterName) {
//		theater.setTheaterName(theaterName);
//		return theaterService.createOrUpdateTheater(theater);
//	}

}
