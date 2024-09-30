package jpa_api_demo.rest_crud_api.RestController;


import jpa_api_demo.rest_crud_api.DAO.MovieDAO;
import jpa_api_demo.rest_crud_api.MovieErrorResponse;
import jpa_api_demo.rest_crud_api.MovieNotFoundException;
import jpa_api_demo.rest_crud_api.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class MovieRestController {

    private MovieDAO movieDAO;

    @Autowired
    public MovieRestController(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }

    @GetMapping("/movies")
    public List<Movie> findAll() {

        return movieDAO.findAll();
    }

    @GetMapping("/movies/{Id}")

    public Movie findById(@PathVariable int Id) {

        return movieDAO.findById(Id);

    }

    @PostMapping("/movies")

    public Movie newMovie(@RequestBody Movie movie) {

        movieDAO.newMovie(movie);

        return movie;
    }

    @DeleteMapping("/movies/{Id}")

    public void deleteMovie(@PathVariable int Id) {

        movieDAO.deleteMovie(Id);
    }


    @ExceptionHandler
    public ResponseEntity<MovieErrorResponse> handleException(MovieNotFoundException exc){

        MovieErrorResponse resp = new MovieErrorResponse();

        resp.setStatus(HttpStatus.NOT_FOUND.value());
        resp.setMessage(exc.getMessage());
        resp.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND );
    }

}
