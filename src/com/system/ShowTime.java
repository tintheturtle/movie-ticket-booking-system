package com.system;

import java.util.*;

public class ShowTime{

    public HashMap<String, ArrayList<Movie>> movieMap = new HashMap<String, ArrayList<Movie>>();
    public ArrayList<Movie> showList;

    // Constructor
    public ShowTime(){
        this.showList = new ArrayList<Movie>();
    }
     
    public void addMovie(String title, String time, String day) {

        Movie addedMovie = new Movie(title, time, day);
        showList.add(addedMovie);

        // If movie is already in map then add movie to the list of times, otherwise just create a new list
        // This doesn't appear to do anything... delete? -- matt
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
        List<String> movieList = new ArrayList<String>(movieMap.keySet());

        int idx = 1;
        for (String show : movieList) {
            System.out.printf("\t\t\t%-20s \t%-20s\n", idx++, show);
        }
    }

    public ArrayList<Movie> displayMovieTimes(String title)
    {
        try {
            ArrayList<Movie> movies = movieMap.get(title);

            int idx = 1;
            for (Movie show : movies) {
                System.out.printf("\t\t%-20s \t%-20s \t\t%-20s\n", idx++, show.date, show.time);
            }

            return movies;
        } catch (NullPointerException e) {

            System.out.println("Invalid movie title. Please try again.");
            return null;
        }

    }

    
}
