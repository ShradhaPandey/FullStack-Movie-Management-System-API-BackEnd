package com.shradha.spring.dao;

import java.util.List;

import com.shradha.spring.model.Movie;

public interface MovieDao {
	
	List<Movie> getListOfMovies();
	
	Movie getMovie(long id);
	
	long addMovie(Movie movie);

	void updateMovie(long id, Movie movie);

	void deleteMovie(long id);

	}