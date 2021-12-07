package com.system;

import java.io.IOException;

public class Employee extends Person{

    public Employee(String employeeID){
        super(employeeID);
    }

    public void addMovie(ShowTime showtimes, String title, String day, String time){
        showtimes.addMovie(title, day, time);   // Potentially have a Movie.addedBy(employeeID) attrib  ?
    }

    public void removeMovie(ShowTime showtimes, String title){
        showtimes.removeMovie(title);
    }


}
