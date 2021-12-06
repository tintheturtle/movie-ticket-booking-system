package com.system;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Booking {

    // hash map with unique IDs as keys and arrays of tickets as values

    Map<String, Ticket> bookingList = new HashMap<>();

    // Method for reserving seats
    public boolean reserve(Movie movie, String letter, int col) {


        movie.reserveSeat(letter, col);


        // Creating ticket object
        Ticket createdTicket = new Ticket(movie, letter, col);

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
