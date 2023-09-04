package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Movie;
import com.demo.exceptions.MovieException;
import com.demo.services.MovieService;

@RestController 
@RequestMapping("/api/movies")
public class MovieController {

	@Autowired
	private MovieService service;
	
	@GetMapping()
	public List<Movie> getAllMovies(){
		return service.getAllMovies();
	}
	
	@PostMapping()
	public Movie createNewMovie(@RequestBody Movie movie){
		return service.saveMovie(movie);
	}

	@GetMapping("/{id}")
	public Movie getMovieByPk(@PathVariable int id) throws MovieException{
		return service.getMovieById(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeMovieByPk(@PathVariable int id) throws MovieException{
		service.deleteMovie(id);
		return ResponseEntity.status(200).build();
	}

	@PutMapping("/{id}")
	public Movie updateMovieByPk(@RequestBody Movie movie, @PathVariable int id) throws MovieException{
		return service.updateMovie(id, movie);
	}
	
}
