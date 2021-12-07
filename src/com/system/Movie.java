package com.system;

import java.util.*;

public class Movie{

    public static ArrayList<String> times = new ArrayList<String>();

    private int rowSize = 10;
    private int colSize = 10;

    boolean seats[][] = new boolean[rowSize][colSize];

    String title;
    String time;
    String date;
    double price;

    // Constructors
    public Movie(String title, String time, String date){
        this.title = title;
        this.time = time;
        this.date  = date;

    }

    // Constructors (via method overloading)
    public Movie(String title, String time){
        this.title = title;
        this.time = time;

    }

    // Method for displaying seats
    public void displaySeats() {

        System.out.println("\t---------------------Screen------------------");

        int idx = 1;
        for (boolean[] row : seats) {

            // Prints row letter
            char letter = (char) (idx + 64);
            System.out.print("\t " + letter + "\t");
            idx++;

            for (boolean seat : row) {
                if (seat == false) {
                    System.out.print("[ ] ");
                }
                else {
                    System.out.print("[X] ");
                }
            }
            System.out.print("\n");

        }

        // Printing column numbers
        System.out.print("\t " + " " + "\t");
        for (int i = 1; i <= colSize; i++) {
            System.out.print(" " + i + "  ");
        }

        System.out.println("\n \t \t \t[X] Unavailable [ ] Available");
    }

    // Method for checking if seat is available
    public boolean checkSeat(String letter, int col) {
        int row = (int)letter.toCharArray()[0] - 65;
        if (seats[row][col] == true) {
            return false;
        }
        else {
            return true;
        }
    }

    // Reserve seat by marking them as true
    public void reserveSeat(String letter, int col) {
        int row = (int)letter.toCharArray()[0] - 65;
        seats[row][col] = true;
    }


    public boolean equals(Movie show){
        return this.title.equals(show.title);
    }


}
