package com.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Movie;
import com.demo.exceptions.MovieException;
import com.demo.repositories.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repo;

	public List<Movie> getAllMovies(){
		//...
	}

	public Movie getMovieById(int id) throws MovieException{
		//...
	}
	
	public Movie saveMovie(Movie m){
		//...
	}

	public void deleteMovie(int id) throws MovieException{
		//...
	}

	public Movie updateMovie(int id, Movie m) throws MovieException{
		//...
	}
	
}
