package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}
	
	public Movie createMovie(Movie movie) {
		return movieRepository.save(movie);
	}
	
	public Movie getMovieByID(Long id) {
		return movieRepository.findById(id).orElse(null);
	}
	
	public void deleteMovie(Long id) {
		movieRepository.deleteById(id);
	}
	
}
