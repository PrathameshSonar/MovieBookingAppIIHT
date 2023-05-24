package com.pms.MovieBookingApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection="user_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
	
	@Id
	private int loginId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
			
	private String password;
	
	private String mobNo;

}
