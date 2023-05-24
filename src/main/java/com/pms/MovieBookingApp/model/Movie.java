package com.pms.MovieBookingApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection="movie_details")
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Movie {
	
	@Getter
	@Setter
	@AllArgsConstructor
	@ToString
	@NoArgsConstructor
	public static class MovieId {
		private String movieName;
		
		private String theaterName;
		
//		private String description;
//		
//		private String poster;
	}
	
	
	@Id
	private MovieId movieId;
	
	private int allotedSeats;
	
}
