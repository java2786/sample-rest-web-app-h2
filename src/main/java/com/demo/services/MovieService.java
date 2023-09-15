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
		return repo.findAll();
	}

	public Movie getMovieById(int id) throws MovieException{
		Optional<Movie> optional = repo.findById(id);
		if(optional.isPresent()){
			return optional.get();
		} else {
			throw new MovieException("Movie with id #"+id+" not found");
		}
	}
	
	public Movie saveMovie(Movie m){
		return repo.save(m);
	}

	public void deleteMovie(int id) throws MovieException{
		try{
			Movie m = getMovieById(id);
			repo.delete(m);
		} catch (Exception e){
			throw new MovieException("Movie with id #"+id+" not found and hence not deleted");
		}
	}

	public Movie updateMovie(int id, Movie m) throws MovieException{
		try{
			Movie movie = getMovieById(id);

			movie.setDirector(m.getDirector());
			movie.setTitle(m.getTitle());
			movie.setRating(m.getRating());
			return repo.save(movie);
		} catch(MovieException e){
			throw new MovieException("Movie with id #"+id+" not found and thus could not be updated");
		}
	}
	

}
