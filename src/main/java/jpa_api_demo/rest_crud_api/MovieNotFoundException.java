package jpa_api_demo.rest_crud_api;

public class MovieNotFoundException extends RuntimeException{

    public MovieNotFoundException(String message) {
        super(message);
    }
}
