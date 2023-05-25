package com.pms.MovieBookingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.DuplicateKeyException;
import com.pms.MovieBookingApp.model.User;
import com.pms.MovieBookingApp.model.UserLogin;
import com.pms.MovieBookingApp.repository.UserRepo;
import com.pms.MovieBookingApp.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepo userRepo;
	
	@PostMapping("/registerUser")
	public ResponseEntity<User> regiserUser(@RequestBody User user){
		try {
		userRepo.save(user);
		}
		catch(DuplicateKeyException e) {
			System.out.println(e);
		}
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@PostMapping("/loginUser")
	public boolean loginUser(@RequestBody UserLogin userlogin) {
		return userService.loginUser(userlogin);
	}
	
	@PostMapping("/forgot/password")
	public ResponseEntity<String> forgotPassword(@RequestBody UserLogin userlogin){
		return userService.forgetPassword(userlogin);
	}
	
//	@PutMapping("/updateUser/{loginId}")
//	public User updateUser(@RequestBody User user, @PathVariable int loginId) {
//		user.setLoginId(loginId);
//		return userService.createOrUpdateUser(user);
//	}
	
}
