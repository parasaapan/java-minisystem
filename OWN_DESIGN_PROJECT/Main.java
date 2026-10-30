package OWN_DESIGN_PROJECT;

import java.util.Scanner;


public class Main {

    public static int Menu(Scanner input, double total_earnings) {
        System.out.println();
        System.out.println();
        System.out.println("====================================");
        System.out.println("      CRIS'S RENTAL DASHBOARD        ");
        System.out.println("====================================");

        System.out.println("Total Session Earnings: Php [" + (total_earnings) + "] ");
        System.out.println("[1] View Car Fleet Status");
        System.out.println("[2] Rent a Car");
        System.out.println("[3] Return Car");
        System.out.println("[4] Exit System");
        System.out.println("=====================================");
        System.out.print("Choose an option (1-4): ");
        int choice = input.nextInt();

        return choice;
    }

    public static void viewcarStatus(String[] cars, String[] status, double[] rateCar) {
        System.out.println("===============CARS=================");
        System.out.printf("%-7s %-15s %-12s%n", "CAR", "STATUS", "RATE");
        for (int i = 0; i < cars.length; i++) {
            System.out.printf("%-7s %-15s %-12.2f%n",
                    cars[i],
                    status[i],
                    rateCar[i]);
        }
        System.out.println("===================================");

        
    }

    public static double rentingCar(String[] status, double[] rateCar, Scanner input) {

        
        System.out.print("SELECT OPTION (1-3): ");
        int choice = input.nextInt();

        // edge cases 
        if(choice < 1 || choice > 3) {
            System.out.println("INVALID CHOICE");
            return 0;
        }

        // if not available 
        if(status[choice - 1].equals("RENTED OUT")) {
            System.out.println("CAR NOT AVAILABLE\n");
            return 0;
        }

        System.out.print("NUMBER OF DAYS: ");
        int numberDays = input.nextInt();

        if(numberDays <= 0) {
            System.out.println("INVALID NUMBER OF DAYS\n");
            return 0;
        }

        // if valid all then change the RENDTED OUT and return the calculate earnings;

        status[choice - 1] = "RENTED OUT";        
        double earnings_rental = calculateEarnings(numberDays, choice, rateCar) ;
        System.out.println("Success! Total Cost for this Rental Php [" + earnings_rental + "]");

        return calculateEarnings(numberDays, choice, rateCar);


    }


    public static double calculateEarnings (int days, int choice, double[] rateCar) {

        double earnings = days * rateCar[choice - 1];

        return earnings;
    }


    public static void ReturnCar(Scanner input, String[] status) {
        System.out.print("SELECT OPTION (1-3): ");
        int choice = input.nextInt();

        if(choice <= 0 || choice > 3) {
            System.out.println("INVALID CHOICE\n");
            return ;
        }

        if(status[choice - 1].equals("Available")) {
            System.out.println("CAR IS ALREADY IN THE GARAGE\n");
            return;
        }   

        System.out.println("CAR SUCCESSFULL RETURN");
        status[choice - 1] = "Available";
    }

    

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // all the car u own and status
        String[] cars = { "Sedan", "SUV", "Van" };
        String[] status = { "Available", "Available", "Available" };
        double[] rateCar = { 1500, 2500, 3500 };

        double total_earnings = 0;

        int choice_menu = 0;

        do {

            choice_menu = Menu(input, total_earnings);

            switch (choice_menu) {
                case 1:
                    viewcarStatus(cars, status, rateCar);
                    break;
                case 2:
                    viewcarStatus(cars, status, rateCar);   
                   total_earnings +=  rentingCar(status, rateCar, input);
                    break;

                case 3:
                    viewcarStatus(cars, status, rateCar);
                    ReturnCar(input, status);
                    break;  

                case 4: 
                    System.out.println("THANK U FOR USING\n");
                    break;
                default:
                    System.out.println("INVALID OPTION\n");
                    break;
            }

        } while (choice_menu != 4);

        input.close();

    }

}