package jpa_api_demo.rest_crud_api.DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jpa_api_demo.rest_crud_api.MovieNotFoundException;
import jpa_api_demo.rest_crud_api.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;


@Repository
public class MovieDAOImpl implements MovieDAO {


    private EntityManager entityManager;

    @Autowired
    public MovieDAOImpl(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    @Override
    public List<Movie> findAll() {

        TypedQuery<Movie> movies = entityManager.createQuery("FROM Movie", Movie.class);
        return movies.getResultList();

    }

    @Override
    public Movie findById(int Id) {

        return entityManager.find(Movie.class, Id);//("FROM Movie WHERE title =: Id " , Movie.class);

    }

    @Override
    @Transactional
    public void newMovie(Movie movie) {

        entityManager.persist(movie);
    }

    @Override
    @Transactional
    @ExceptionHandler
    public void deleteMovie(int Id) {

        Movie theMovie = entityManager.find(Movie.class, Id);

        if (theMovie != null) {

            entityManager.remove(theMovie);

        }
        else

            throw new MovieNotFoundException("movie with given Id not found:" + Id);
    }
}