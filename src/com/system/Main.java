package com.system;

public class Main {

    static Scanner kb = new Scanner(System.in);
    static String PASSWORD = "password";

    public static void main(String[] args) {
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
                    clearscreen();
                    int customerChoice;
                    do {    // encloses full case 1
                        System.out.println("\n\n\n------------------------------------------------"); 
                        System.out.println("--  WELCOME TO OUR MOVIE TICKET BOOKING SYSTEM  --");
                        System.out.println("--------------------------------------------------");
                        System.out.println("--  1. See Movie Showtimes                      --");
                        System.out.println("--  2. Book Ticket                              --");
                        System.out.println("--  3. View your Ticket(s)                      --");
                        System.out.println("--  4. Cancel Ticket                            --");
                        System.out.println("--  5. Back                                     --");
                        System.out.println("--------------------------------------------------");
                        
                        customerChoice = kb.nextInt();
                        switch (customerChoice)
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
                            clearscreen();
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
                        clearscreen();
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

    private boolean login(){
        clearscreen();
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
}
