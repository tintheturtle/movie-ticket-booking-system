package com.system;

import java.util.*;

public class ShowTime{

    public HashMap<String, ArrayList<Movie>> movieMap = new HashMap<String, ArrayList<Movie>>();
    public ArrayList<Movie> showList;

    // Constructor
    public ShowTime(){
        this.showList = new ArrayList<Movie>();
    }
     
    public void addMovie(String title, String time) {

        Movie addedMovie = new Movie(title, time);
        showList.add(addedMovie);

        // If movie is already in map then add movie to the list of times, otherwise just create a new list
        if (movieMap.containsKey(title)) {
            ArrayList<Movie> movieTimes = movieMap.get(title);
            movieTimes.add(addedMovie);
        } else {
            ArrayList<Movie> newMovieTimeList = new ArrayList<Movie>();
            newMovieTimeList.add(addedMovie);
            movieMap.put(title, newMovieTimeList);
        }


    }

    /* Formatted as such for showMovies() in Main */
    public void showMovies()
    {
        for (Movie show : showList) {
            System.out.printf("%-20s %-20s\n", show.title, show.time);
        }
    }

    public void displayMovieShowtimes(String title)
    {

        for (Movie show : showList) {
            System.out.printf("%-20s %-20s\n", show.title, show.time);
        }
    }

    
}
