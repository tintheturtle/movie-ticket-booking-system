package com.system;

import java.util.Map;
import java.util.UUID;

public class Booking {

    // hash map with unique IDs as keys and arrays of tickets as values

    Map<String, Ticket> bookingList;

    // Method for reserving seats
    public boolean reserve(Movie movie, String letter, int row) {

        // Checking if seat is taken
        int col = (int)letter.toCharArray()[0] - 64;

        if (movie.selectSeats(letter, row)) {
            System.out.println("This seat is currently unavailable. Please select another seat");
            return false;
        }


        // Creating ticket object
        Ticket createdTicket = new Ticket(movie, letter, row);

        // Generate UID and ask user to save it for their own reference
        String id = UUID.randomUUID().toString().replace("-", "");

        // Store ticket in hash map with ID
        bookingList.put(id, createdTicket);

        System.out.println("Your seat has been reserved! Please keep this reference ID to check/update your ticket: ");
        System.out.println(id);

        return true;

    }

    public Ticket getTicket(String id) {
        try {
            Ticket ticket = bookingList.get(id);
            return ticket;
        } catch (NullPointerException e) {
            System.out.println("Invalid ticket ID. Please try again");
            return null;
        }
    }

}
