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

import com.pms.MovieBookingApp.model.Movie;
import com.pms.MovieBookingApp.repository.MovieRepo;
import com.pms.MovieBookingApp.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@Autowired
	private MovieRepo movieRepo;

	@PostMapping("/add")
	public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
		movieRepo.save(movie);

		return new ResponseEntity<Movie>(movie, HttpStatus.OK);
	}

//	@PutMapping("/update/{movieName}")
//	public Movie updateMovie(@RequestBody Movie movie, @PathVariable M movieName) {
//		movie.setMovieId(movieId);
//		return movieService.createOrUpdateMovie(movie);
//	}

	@DeleteMapping("/{movieName}/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteMovie(@PathVariable("movieName") String movieName,
			@PathVariable("id") String theatreName) {
		return movieService.deleteMovie(movieName, theatreName);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Movie>> allMovies() {
		List<Movie> movies = movieRepo.findAll();
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}

	@GetMapping("/search/{movieName}")
	public ResponseEntity<?> searchMovie(@PathVariable("movieName") String movieName) {
		List<Movie> searchedMovies = movieService.searchMovie(movieName);
		if (searchedMovies.size() != 0) {
			return new ResponseEntity<List<Movie>>(searchedMovies, HttpStatus.OK);
		}
		return new ResponseEntity<String>("No movies found", HttpStatus.OK);
	}

	@GetMapping("/{movieName}/theaters")
	public ResponseEntity<List<Movie>> getTheatres(@PathVariable("movieName") String movieName) {
		List<Movie> movies = movieService.showMovieTheatre(movieName);
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}

}
