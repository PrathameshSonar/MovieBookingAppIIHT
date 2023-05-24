//package com.pms.MovieBookingApp.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.pms.MovieBookingApp.model.Theater;
//import com.pms.MovieBookingApp.repository.TheaterRepo;
//
//@Service
//public class TheaterService {
//	
//	@Autowired
//	private TheaterRepo theaterRepo;
//	
//	public Theater createOrUpdateTheater(Theater theater){
//		
//		return theaterRepo.save(theater);
//	}
//	
//	public void deleteTheater(String theaterName) {
//		theaterRepo.deleteById(theaterName);
//	}
//	
//	public List<Theater> listTheater(){
//		return theaterRepo.findAll();
//	}
//	
//	
//}
