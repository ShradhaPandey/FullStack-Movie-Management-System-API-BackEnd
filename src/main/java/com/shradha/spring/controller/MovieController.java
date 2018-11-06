package com.shradha.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shradha.spring.model.Movie;
import com.shradha.spring.service.MovieService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class MovieController {

	
	@Autowired
    private MovieService movieService;
	
	/*---get all movies---*/
	   @GetMapping("/movie")
	   public ResponseEntity<List<Movie>> list() {
	   List<Movie> movies = movieService.getListOfMovies();
	   return ResponseEntity.ok().body(movies);
	   }
	
	   /*---Get a movie by id---*/
	   @GetMapping("/movie/{id}")
	   public ResponseEntity<Movie> get(@PathVariable("id") long id) {
		   Movie movie = movieService.getMovie(id);
	      return ResponseEntity.ok().body(movie);
	   }		   
	   
	
	   /*---Update a movie by id---*/
	   @PutMapping("/movie/{id}")
	   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Movie movie) {
		   movieService.updateMovie(id, movie);
	      return ResponseEntity.ok().body("Movie details has been updated successfully.");
	   }	
	   
	   
	   /*---Add new movie---*/
	   @PostMapping("/movie")
	   public ResponseEntity<?> save(@RequestBody Movie movie) {
	      long id = movieService.addMovie(movie);
	      return ResponseEntity.ok().body("New Movie has been saved with ID:" + id);
	   }
	   
	   
	   /*---Delete a movie by id---*/
	   @DeleteMapping("/movie/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
		   movieService.deleteMovie(id);
	      return ResponseEntity.ok().body("Movie has been deleted successfully.");
	   }
	   
	
}
