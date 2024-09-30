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

    @Column(name="year")
    private int year;

    public Movie(){

    }

    public Movie(String title,String genre,String composer,int year){

        this.title = title;
        this.genre = genre;
        this.composer = composer;
        this.year = year;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
