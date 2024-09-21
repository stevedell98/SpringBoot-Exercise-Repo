package jpa_api_demo.rest_crud_api.entity;


import jakarta.persistence.*;

@Entity
@Table(name="movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int Id;

    @Column(name="title")
    private String title;

    @Column(name="genre")
    private String genre;

    @Column(name="composer")
    private String composer;

    @Column(name="release")
    private int year;

    public Movie(){

    }

    public Movie(String title,String genre,String composer,int year){

        this.title = title;
        this.genre = genre;
        this.composer = composer;
        this.year = year;
    }

}
