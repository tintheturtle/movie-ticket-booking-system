package com.system;

import java.util.*;

public class Movie{

    public static HashMap<String, Movie> movieMap = new HashMap<String, Movie>();

    private int rowSize = 10;
    private int colSize = 10;

    boolean seats[][] = new boolean[rowSize][colSize];

    String title;
    String time;
    double price;

    public Movie(String title, String time, double price){
        this.title = title;
        this.time = time;
        this.price  = price;

    }

    public Movie(String title, String time){
        this.title = title;
        this.time = time;

    }

    public String getTitle(){ return this.title; }

    @Override
    public String toString(){ return this.title; }

    public void setPrice(double price){
        this.price = price;
    }

    public void displaySeats() {

        System.out.println("\t---------------------Screen------------------");

        int idx = 1;
        for (boolean[] row : seats) {

            // Prints row letter
            char col = (char) (idx + 64);
            System.out.print("\t " + col + "\t");
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

}
