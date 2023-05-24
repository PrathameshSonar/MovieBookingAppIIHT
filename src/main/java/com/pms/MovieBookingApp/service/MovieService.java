package com.pms.MovieBookingApp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pms.MovieBookingApp.model.Movie;
import com.pms.MovieBookingApp.model.Ticket;
import com.pms.MovieBookingApp.repository.MovieRepo;

@Service
public class MovieService {

	@Autowired
	private MovieRepo movieRepo;

	public List<Movie> searchMovie(String movieName) {
		movieName = movieName.substring(0, 1).toUpperCase() + movieName.substring(1).toLowerCase();
		
		List<Movie> movies = movieRepo.findAll();

		List<Movie> searchedMovie = new ArrayList<>();
		for (Movie movie : movies) {
		
			if (movie.getMovieId().getMovieName().contains(movieName)) {
				searchedMovie.add(movie);
			}
		}
		
		return searchedMovie;
	}

	public ResponseEntity<Map<String, Boolean>> deleteMovie(String movieName, String theaterName) {
		movieRepo.deleteById(new Movie.MovieId(movieName, theaterName));
		Map<String, Boolean> response = new HashMap<>();

		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);

	}

	public List<Movie> showMovieTheatre(String movieName) {
		List<Movie> movies = movieRepo.findAll();
		List<Movie> theatres = movies.stream().filter((movie) -> movie.getMovieId().getMovieName().equals(movieName))
				.collect(Collectors.toList());

		return theatres;
	}

	public boolean updateTicketCount(Ticket ticket) {
		Movie movie= movieRepo.findById(new Movie.MovieId(ticket.getMovieName(), ticket.getTheaterName())).get();
		if(ticket.getNoOfTickets()<movie.getAllotedSeats()) {
			int count=movie.getAllotedSeats()-ticket.getNoOfTickets();
			movie.setAllotedSeats(count);
			movieRepo.save(movie);
			return true;
		}
		return false;
	}

}
