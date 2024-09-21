package jpa_api_demo.rest_crud_api.RestController;


import jpa_api_demo.rest_crud_api.DAO.MovieDAO;
import jpa_api_demo.rest_crud_api.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieRestController {

    private MovieDAO movieDAO;

    @Autowired
    public MovieRestController(MovieDAO movieDAO){
        this.movieDAO = movieDAO;
    }

    @GetMapping("/movies")
    public List<Movie> findAll(){

        return movieDAO.findAll();
    }

    @GetMapping("/movies/{Id}")

        public Movie findById(@PathVariable("Id") int Id){

        return movieDAO.findById(Id);

        }




}
