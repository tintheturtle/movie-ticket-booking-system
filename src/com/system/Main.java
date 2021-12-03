package com.system;

public class Main {

    static Scanner kb = new Scanner(System.in);
    static String PASSWORD = "password";

    public static void main(String[] args) {
	// write your code here
    }

    public int mainPage(){
        System.out.println("\n\n\n-------------------------");
        System.out.println("-  MAIN PAGE - TYPE CHOICE TO ADVANCE");
        System.out.println("-  1. VIEW SHOWINGS/PURCHASE TICKET");
        System.out.println("-  2. EMPLOYEE LOGIN\n");
        int choice = kb.nextInt();
        if (choice != 1 or choice != 2)
            return -1;
        return choice;
    }


    public boolean login(){
        System.out.println("\n\n\n-------------------------"); // 25 -
        System.out.println("-  EMPLOYEE LOGIN");
        System.out.print("\n-  PASSWORD: ");
        String pass = kb.nextLine();
        if (pass.equals(PASSWORD))
            return true;
        else{
            System.out.println("INCORRECT LOGIN. RETRY? (Y/N)");
            if (kb.next().equals('Y'))
                return login();
            else
                return false;
        }
    }
}
