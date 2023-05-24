package com.pms.MovieBookingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.MovieBookingApp.model.User;
import com.pms.MovieBookingApp.repository.UserRepo;
import com.pms.MovieBookingApp.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepo userRepo;
	
	@PostMapping("/regiterUser")
	public ResponseEntity<User> register(@RequestBody User user) {
		userRepo.save(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PutMapping("/updateUser/{loginId}")
	public User updateUser(@RequestBody User user, @PathVariable int loginId) {
		user.setLoginId(loginId);
		return userService.createOrUpdateUser(user);
	}
	
	@DeleteMapping("/deleteUser/{loginId}")
	public ResponseEntity<?> deleteUser(@PathVariable int loginId) {
		userService.deleteUser(loginId);
		return new ResponseEntity<String>("User Deleted", HttpStatus.OK);
	}
	
//	@GetMapping("/listUser")
//	public List<User> getUserList(){
//		List<User> userList = userService.listUser(); 
//		
//		for(User user: userList) {
//			System.out.println(user);
//		}
//		return userService.listUser();
//	}
//	
//	@GetMapping("/search/{userName}")
//	public User searchUser(@PathVariable String userName) {
//		return userService.findUser(userName);
//	}
	
	

}
