package com.pms.MovieBookingApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pms.MovieBookingApp.model.User;
import com.pms.MovieBookingApp.model.UserLogin;
import com.pms.MovieBookingApp.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public boolean loginUser(UserLogin userLogin) {
		User user = userRepo.findByEmail(userLogin.getEmail());
		
		if(user != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public ResponseEntity<String> forgetPassword(UserLogin userLogin){
		User user=userRepo.findByEmail(userLogin.getEmail());
		if(user!=null) {
			user.setPassword(userLogin.getPassword());
			userRepo.save(user);
			return new ResponseEntity<String>("Password Updated Succesfully!!!", HttpStatus.OK);
		}
		
		//user does not exists
		return new ResponseEntity<String>("User Does not exits!!", HttpStatus.OK);
	}
	

}
