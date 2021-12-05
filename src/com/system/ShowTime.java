package com.system;

import java.util.*;

public class ShowTime{

    public ArrayList<Movie> showList;

    // Constructor
    public ShowTime(){
        this.showList = new ArrayList<Movie>();
    }

    public void addMovie(String title, String time, double price) {

        Movie addedMovie = new Movie(title, time, price);
        showList.add(addedMovie);

    }

    /* Formatted as such for showMovies() in Main */
    public void showMovies()
    {
        for (Movie show : showList) {
            System.out.printf("%-20s %-20s\n", show.title, show.time);


        }
    }

    
}
