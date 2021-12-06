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
        for (Movie show : showList) {
            System.out.printf("%-20s %-20s\n", show.title, show.time);
        }
    }


    public boolean displayShowtimeForMovie(String title)
    {
        for (Movie show : showList) {
            if (show.title.equals(title)){
                System.out.printf("%-20s %-20s\n", show.title, show.time);
                return true;
            }
        }
        System.out.println("Movie could not be found, press any key to return to main menu");
        return false;
    }

    
}
