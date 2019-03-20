package com.mihaita.movieapp;

import java.io.Serializable;

public class MovieBean implements Serializable {

    private int movieID;
    private static int lastMovieID;
    private String movieName;
    private float movieRating;

    public MovieBean( String movieName, float movieRating) {
        this.movieID = getLastMovieID() +1;
        this.movieName = movieName;
        this.movieRating = movieRating;
        setLastMovieID(movieID);
    }

    public int getMovieID() {
        return movieID;
    }

    public static int getLastMovieID() {
        return lastMovieID;
    }

    public static void setLastMovieID(int lastMovieID) {
        MovieBean.lastMovieID = lastMovieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;


    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public float getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(float movieRating) {
        this.movieRating = movieRating;
    }
}
