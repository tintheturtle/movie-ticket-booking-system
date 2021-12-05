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

    static ShowTime showtimes = new ShowTime();


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
                        System.out.println("--  2. See Showtime and Price for a Movie       --");
                        System.out.println("--  3. Book Ticket                              --");
                        System.out.println("--  4. View your Ticket(s)                      --");
                        System.out.println("--  5. Cancel Ticket                            --");
                        System.out.println("--  6. Back                                     --");
                        System.out.println("--------------------------------------------------");
                        
                        customerChoice = kb.nextInt();
                        switch (customerChoice)
                        {
                            case 1:
                                seeMovieList();
                                customerChoice=0;   // Goes back to customer page
                                break;
                                
                            case 2:
                                ;

                            case 3:
                                ;
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
                                    ;
                                case 2:
                                    ;
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

    private static <Movie> void seeMovieList(){
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
        String pass = kb.nextLine();
        if (pass.equals(PASSWORD))
            return true;
        else{
            System.out.print("\n\nINCORRECT LOGIN. RETRY? (Y/N): ");
            if (kb.next().equals('Y'))
                return login();
            else
                return false;
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
            System.out.println("Console cleared");
        }

        System.out.println("Console cleared");
    }


}
