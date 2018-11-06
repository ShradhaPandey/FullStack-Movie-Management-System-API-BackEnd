package com.shradha.spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.shradha.spring.model.Movie;


@Repository
public class MovieDaoImpl implements MovieDao{
	 @SuppressWarnings("unchecked")
	@Override
	   public List<Movie> getListOfMovies() {
	      List<Movie> list = sessionFactory.getCurrentSession().createQuery("from Movie").list();
	      return list;
	   }
	 
	 @Override
	   public Movie getMovie(long id) {
	      return sessionFactory.getCurrentSession().get(Movie.class, id);
	   }

	 @Override
	   public void updateMovie(long id, Movie movie) {
	      Session session = sessionFactory.getCurrentSession();
	      Movie movie2 = session.byId(Movie.class).load(id);
	      movie2.setTitle(movie.getTitle());
	      movie2.setLeadActor(movie.getLeadActor());
	      session.flush();
	   }
	 
	@Autowired
	   private SessionFactory sessionFactory;

	   @Override
	   public long addMovie(Movie movie) {
	      sessionFactory.getCurrentSession().save(movie);
	      return movie.getId();
	   }

	  

	   @Override
	   public void deleteMovie(long id) {
		   Movie movie = sessionFactory.getCurrentSession().byId(Movie.class).load(id);
	      sessionFactory.getCurrentSession().delete(movie);
	   }

	}
