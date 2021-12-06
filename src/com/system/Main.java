package com.system;
      
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner kb = new Scanner(System.in);
    static String PASSWORD = "password";

    // Showtime list
    static ShowTime showtimes = new ShowTime();

    // Boolean for flagging if current user is an employee
    static boolean isEmployee = false;

    public static void displayMovieList(){
        System.out.println("\n\n\n------------------------------------------------");
        System.out.println("----  Movie  ------  |  ------  [Dates]  ---------");
        System.out.println("--------------------------------------------------");
        int num_movies = showtimes.showList.size();
        if (num_movies == 0){
            System.out.println("CURRENTLY NO MOVIES");
        }
        else{
            showtimes.showMovies();
            System.out.println("--------------------------------------------------");
        }
        System.out.println("\n\nPRESS ANY KEY TO CONTINUE");
        kb.next();

    }

    private static boolean login() throws IOException, InterruptedException {
        clearconsole();
        System.out.println("\n\n\n-------------------------"); // 25 -
        System.out.println("-  EMPLOYEE LOGIN");
        System.out.print("\n-  PASSWORD: ");
        String pass = kb.next();
        if (pass.equals(PASSWORD)) {

            return true;
        }
        else{
            System.out.print("\n\nINCORRECT LOGIN. RETRY? (Y/N): ");
            String retry = kb.next();
            if (retry.equals('Y')) {
                return login();
            }
            else {
                return false;
            }
        }
    }

    /* Copied from: https://stackoverflow.com/questions/2979383/how-to-clear-the-console */
    public static void clearconsole() throws IOException, InterruptedException{
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
        }

        System.out.println("\n\n");
    }


    public static void main(String[] args) throws InterruptedException, IOException {

        while (true) // Encloses entire function
        {
            System.out.println("\n\n\n------------------------------------------------"); 
            System.out.println("--  WELCOME TO OUR MOVIE TICKET BOOKING SYSTEM  --");
            System.out.println("--------------------------------------------------");
            System.out.println("--  1. VIEW SHOWINGS/PURCHASE TICKET            --");
            System.out.println("--  2. EMPLOYEE LOGIN                           --");
            System.out.println("--------------------------------------------------");

            int menuChoice = kb.nextInt();
            switch (menuChoice)
            {
                case 1: 
                    clearconsole();
                    int customerChoice;
                    do {    // encloses full case 1
                        System.out.println("\n\n\n------------------------------------------------"); 
                        System.out.println("--  WELCOME TO OUR MOVIE TICKET BOOKING SYSTEM  --");
                        System.out.println("--------------------------------------------------");
                        System.out.println("--  1. List Movies                              --");
                        System.out.println("--  2. See Showtimes for a Movie                --");
                        System.out.println("--  3. Book Ticket                              --");
                        System.out.println("--  4. View your Ticket(s)                      --");
                        System.out.println("--  5. Cancel Ticket                            --");
                        System.out.println("--  6. Back                                     --");
                        System.out.println("--------------------------------------------------");
                        
                        customerChoice = kb.nextInt();
                        switch (customerChoice)
                        {
                            case 1:
                                displayMovieList();
                                break;
                                
                            case 2:
                                String movieTitle;
                                clearconsole();
                                System.out.println("Which movie would you like to see the showtimes for?");
                                String movieTitle = kb.nextLine();
                                boolean validTitle = showtimes.displayShowtimeForMovie(movieTitle); // Prints all necessary info

                                if (!validTitle){
                                    // Read next key, return to main menu.
                                    kb.next();
                                }

                                break;

                            case 3:
                                // Selecting Movie/Booking Ticket
                                System.out.println("Which movie would you like to see?");
                                String movieTitle = kb.nextLine();  
                                // I think we need a method getMovieFromTitle(String)->Movie in ShowTime class

                                int availableSeats = 0;




                                // Reserving seat
                                System.out.printf("%d Seats available. How many seats would you like to reserve?\n", availableSeats);
                                int reserveNum = kb.nextInt();
                                if (reserveNum < 0 || availableSeats < reserveNum) {
                                    //System.out.println("Please try again and enter a number greater than 0.");
                                    System.out.println("Could not reserve specified number of seats, please ensure your number is valid.")
                                }

                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                break;  // actual implementation
                            default:
                                System.out.println("\n\nPLEASE ENTER A VALID CHOICE");
                                customerChoice = 0;
                        }
                    } while (customerChoice != 6); // Set to 0 at the end of each case except exit case (6)
                    break;

                
                case 2:
                    if (login()){
                        int employeeChoice;
                        do{
                            clearconsole();
                            System.out.println("\n\n\n------------------------------------------------");
                            System.out.println("----------------  Employee Panel   ---------------");
                            System.out.println("--------------------------------------------------");
                            System.out.println("--  1. See Movie Showtimes                      --");
                            System.out.println("--  2. Add Movie                                --");
                            System.out.println("--  3. Add New Showtime                         --");
                            System.out.println("--  4. See Issued Tickets                       --");
                            System.out.println("--  5. Back                                     --");
                            System.out.println("--------------------------------------------------");

                            employeeChoice = kb.nextInt();
                            switch (employeeChoice)
                            {
                                case 1:
                                    displayMovieList();
                                    customerChoice=0;
                                case 2:
                                    System.out.println("-- Please enter movie title :");
                                    String title = kb.nextLine();
                                    System.out.println("-- Please enter movie time and day (DD/MM/YY) :");
                                    String time = kb.nextLine();

                                    showtimes.addMovie(title, time);
                                    break;
                                case 3:
                                    ;
                                case 4:
                                    ;
                                case 5:
                                    break; // actual implementation
                                default:
                                    System.out.println("\n\nPLEASE ENTER A VALID CHOICE");
                                    employeeChoice = 0;
                            }
                        } while (employeeChoice == 0);
                    }   // if login()
                    else{
                        clearconsole();
                        System.out.println("\n\n\n------------------------------------------------");
                        System.out.println("----------------  INVALID ACCESS   ---------------");
                        System.out.println("--------------------------------------------------");
                        System.out.println("PRESS ANY KEY TO GO BACK TO MAIN MENU");
                        kb.next();
                    }
                    break;  // Needs to be double-checked... might need to be after the most recent do/while loop instead
                
                default:
                    System.out.println("\n\nPLEASE ENTER A VALID CHOICE");
            }
        }
    }




}
