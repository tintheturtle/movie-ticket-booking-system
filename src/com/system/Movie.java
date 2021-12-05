package com.system;

import java.util.*;

public class Movie{

    // Associates Movie title to Movie obj
    public static HashMap<String, Movie> movieMap = new HashMap<String, Movie>();
    // public static ArrayList<Movie> movieList = new ArrayList<Movie>();

    String title;
    String time;
    double price;

    public Movie(String title, String time, double price){
        this.title = title;
        this.time = time;
        this.price  = price;

    }

    public String getTitle(){ return this.title; }
    public double getPrice(){ return this.price; }

    @Override
    public String toString(){ return this.title; }

    public void setPrice(double price){
        this.price = price;
    }

}
