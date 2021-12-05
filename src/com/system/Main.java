package com.system;
      
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner kb = new Scanner(System.in);
    static String PASSWORD = "password";

    // Showtime list
    static ShowTime showtimes = new ShowTime();

    // Boolean for flagging if current user is an employee
    static boolean isEmployee = false;

    public static void displayMovieList(){
        System.out.println("\n\n\n\t\t ------------------------------------------------");
        System.out.println("\t\t ----  Movie  ------  |  ------  [Dates]  ---------");
        System.out.println("\t\t --------------------------------------------------");
        int num_movies = showtimes.showList.size();
        if (num_movies == 0){
            System.out.println("No movies are showing.");
        }
        else{
            showtimes.showMovies();
            System.out.println("\t\t --------------------------------------------------");
        }
        System.out.println("\n\nPress C + Enter to Continue");
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
            System.out.println("\n\n\n\t\t ------------------------------------------------");
            System.out.println("\t\t --  WELCOME TO OUR MOVIE TICKET BOOKING SYSTEM  --");
            System.out.println("\t\t --------------------------------------------------");
            System.out.println("\t\t --  1. VIEW SHOWINGS/PURCHASE TICKET            --");
            System.out.println("\t\t --  2. EMPLOYEE LOGIN                           --");
            System.out.println("\t\t --------------------------------------------------");
            System.out.print("Enter an option: ");
            int menuChoice = kb.nextInt();
            switch (menuChoice)
            {
                case 1: 
                    clearconsole();
                    int customerChoice;
                    do {    // encloses full case 1
                        System.out.println("\n\n\n\t\t ------------------------------------------------");
                        System.out.println("\t\t --  WELCOME TO OUR MOVIE TICKET BOOKING SYSTEM  --");
                        System.out.println("\t\t --------------------------------------------------");
                        System.out.println("\t\t --  1. List Movies                              --");
                        System.out.println("\t\t --  2. See Showtimes for a Movie                --");
                        System.out.println("\t\t --  3. Book Ticket                              --");
                        System.out.println("\t\t --  4. View your Ticket(s)                      --");
                        System.out.println("\t\t --  5. Cancel Ticket                            --");
                        System.out.println("\t\t --  6. Back                                     --");
                        System.out.println("\t\t --------------------------------------------------");

                        System.out.print("Enter an option: ");
                        customerChoice = kb.nextInt();

                        // Consumes newline character
                        kb.nextLine();

                        switch (customerChoice)
                        {
                            case 1:
                                displayMovieList();
                                customerChoice=0;   // Goes back to customer page
                                break;
                                
                            case 2:
                                System.out.println("Which movie would you like to see the showtimes for?");
                                String title = kb.nextLine();

                                System.out.println("----  Index  ------  |  ------  [Dates]  ---------  |  ------  [Times]  ---------");
                                System.out.println("---------------------------------------------------------------------------------");
                                showtimes.displayMovieTimes(title);

                                System.out.println("\n\nPress C + Enter to Continue");
                                kb.next();

                                customerChoice = 0;
                                break;

                            case 3:
                                // Selecting Movie
                                System.out.println("Which movie would you like to see?");
                                String choice = kb.nextLine();

                                // Selecting Time
                                System.out.println("What time would you like to see " + choice + "?");
                                ArrayList<Movie> selections = showtimes.displayMovieTimes(choice);
                                int selectedTime = kb.nextInt();




                                // Reserving seat
                                System.out.println("How many seats would you like to reserve?");
                                int reserveNum = kb.nextInt();
                                if (reserveNum < 0) {
                                    System.out.println("Please try again and enter a number greater than 0.");
                                }


                                break;
                            case 4:
                                ;
                            case 5:
                                ;
                            case 6:
                                break;  // actual implementation
                            default:
                                System.out.println("\n\nPLEASE ENTER A VALID CHOICE");
                                customerChoice = 0;
                        }
                    } while (customerChoice == 0); // Set in error case
                    break;

                
                case 2:
                    if (login()){
                        int employeeChoice;
                        do{
                            clearconsole();
                            System.out.println("\n\n\n\t\t ------------------------------------------------");
                            System.out.println("\t\t ----------------  Employee Panel   ---------------");
                            System.out.println("\t\t --------------------------------------------------");
                            System.out.println("\t\t --  1. See Movie Showtimes                      --");
                            System.out.println("\t\t --  2. Add Movie                                --");
                            System.out.println("\t\t --  3. Add New Showtime                         --");
                            System.out.println("\t\t --  4. See Issued Tickets                       --");
                            System.out.println("\t\t --  5. Back                                     --");
                            System.out.println("\t\t --------------------------------------------------");

                            System.out.print("Enter an option: ");
                            try {
                                employeeChoice = kb.nextInt();
                            } catch (InputMismatchException e) {
                                employeeChoice = 10;
                            }
                            kb.nextLine();
                            switch (employeeChoice)
                            {
                                case 1:
                                    displayMovieList();
                                    customerChoice=0;
                                case 2:
                                    System.out.println("-- Please enter movie title :");
                                    String title = kb.nextLine();
                                    title.replace('\n', ' ');
                                    System.out.println("-- Please enter the day of the movie (DD/MM/YY) :");
                                    String day = kb.nextLine();

                                    System.out.println("-- Please enter the time of the movie (HH:MM) :");
                                    String time = kb.nextLine();

                                    showtimes.addMovie(title, time, day);
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
