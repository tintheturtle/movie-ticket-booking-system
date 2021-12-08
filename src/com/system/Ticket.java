package com.system;

public class Ticket {

    private Movie movie;
    private String row;
    private int col;


    //Constructor with ticket information
    public Ticket(Movie reserved, String row, int col) {
        this.movie = reserved;
        this.row = row;
        this.col = col;
    }

    //Display ticket information
    public void display() {
        System.out.println("\t Ticket Information:");
        System.out.println("\t Seat: " + row + col);
        System.out.println("\t Movie: " + movie.title);
        System.out.println("\t Time: " + movie.time);
    }

}
