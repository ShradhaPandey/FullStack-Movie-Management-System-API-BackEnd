package com.shradha.spring.service;

import java.util.List;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.shradha.spring.dao.MovieDao;
import com.shradha.spring.model.Movie;

@Service
@Transactional(readOnly = true)

public class MovieServiceImpl implements MovieService{

	
	@Autowired
	private MovieDao movieDao;
	
	@Override
	public List<Movie> getListOfMovies() {
		    return movieDao.getListOfMovies();
	}

	@Override
	public Movie getMovie(long id) {
		return movieDao.getMovie( id);
	}

	@Transactional
	@Override
	public long addMovie(Movie movie) {
		return movieDao.addMovie(movie);
	}

	@Transactional
	@Override
	public void updateMovie(long id, Movie movie) {
		movieDao.updateMovie(id, movie);
		
	}

	@Transactional
	@Override
	public void deleteMovie(long id) {
		movieDao.deleteMovie(id);
		
	}

	   
	}