package jpa_api_demo.rest_crud_api.DAO;

import jpa_api_demo.rest_crud_api.entity.Movie;

import java.util.List;

public interface MovieDAO {

    public List<Movie> findAll();

    public Movie findById(int Id);

   public void newMovie(Movie movie);
//
   public void deleteMovie(int id);

}
