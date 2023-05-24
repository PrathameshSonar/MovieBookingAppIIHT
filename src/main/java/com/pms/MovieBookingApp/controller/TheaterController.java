//package com.pms.MovieBookingApp.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.pms.MovieBookingApp.model.Theater;
//import com.pms.MovieBookingApp.service.TheaterService;
//
//@RestController
//@RequestMapping("/theater")
//public class TheaterController {
//	
//	@Autowired
//	private TheaterService theaterService;
//	
//	@PostMapping("/createTheater")
//	public Theater createTheater(@RequestBody Theater theater) {
//		return theaterService.createOrUpdateTheater(theater);
//	}
//	
//	@PutMapping("/updateTheater/{theaterName}")
//	public Theater updateTheater(@RequestBody Theater theater, @PathVariable String theaterName) {
//		theater.setTheaterName(theaterName);
//		return theaterService.createOrUpdateTheater(theater);
//	}
//	
//	@DeleteMapping("/deleteTheater/{theaterId}")
//	public ResponseEntity<?> deleteTheater(@PathVariable String theaterName) {
//		theaterService.deleteTheater(theaterName);
//		return new ResponseEntity<String>("Theater Deleted", HttpStatus.OK);
//	}
//	
//	@GetMapping("/listTheater")
//	public List<Theater> getTheaterList(){
//		List<Theater> theaterList = theaterService.listTheater(); 
//		
//		for(Theater theater: theaterList) {
//			System.out.println(theater);
//		}
//		return theaterService.listTheater();
//	}
//	
//	
//
//}
