package STOREINVENTORYPOS;

import java.util.Scanner;

public class Main {

    public static int menu(int choice, Scanner input) {
        System.out.println("==== STORE INVENTORY ====");
        System.out.println("1.View Product");
        System.out.println("2.Add Product");
        System.out.println("3.Search Product");
        System.out.println("4.Restock Product");
        System.out.println("5.Sell Product");
        System.out.println("6.Remove Product");
        System.out.println("7.Sales Summary");
        System.out.println("8.Exit");
        System.out.print("ENTER CHOICE: ");
        choice = input.nextInt();

        return choice;

    }

    public static boolean Check_Empty(int productcount) {
        if (productcount == 0) {
            return true;
        } else {
            return false;
        }
    }

    // View the products
    public static void ViewProduct(String[] productId, String[] productName, double[] price, int[] stock,
            int productcount) {
        System.out.println("=======================================================");
        System.out.printf("%-10s %-15s %-10s %-7s%n", "ID", "PRODUCT", "PRICE", "STOCK");
        for (int i = 0; i < productcount; i++) {
            System.out.printf("%-10s %-15s %-10.2f %-7d%n",
                    productId[i], productName[i], price[i], stock[i]);
        }
        System.out.println("=======================================================");

    }
    // Add product

    public static int Addproduct(String[] productId, String[] productName, double[] price, int[] stock,
            int productcount, Scanner input) {
                input.nextLine();
        while (true) {
            boolean istrue = false;

            System.out.print("ENTER PRODUCT ID: ");
            productId[productcount] = input.nextLine();

            if (productId[productcount] == "") {
                System.out.println("CANNOT BE EMPTY");
                istrue = true;
            }

            for (int i = 0; i < productcount; i++) {
                if (productId[productcount].equals(productId[i])) {
                    System.out.println("PRODUCT ID ALREADY EXIST");
                    istrue = true;
                    break;
                }
            }

            if (!istrue) {
                break;
            }

        }

        input.nextLine();

        while(true) {
            System.out.print("ENTER PRODUCT NAME: ");
            productName[productcount] = input.nextLine();

            if(productName[productcount] != "") {
                break;
            }

            System.out.println("PRODUCT NAME CANNOT BE EMPTY");
        }

        while(true) {
            System.out.print("ENTER PRICE OF THIS PRODUCT: ");
            price[productcount] = input.nextDouble();
            if(price[productcount] > 0) {
                break;
            }

            System.out.println("CANNOT BE NEGATIVE");
        }

         while(true) {
            System.out.print("ENTER STOCK OF THIS PRODUCT: ");
            stock[productcount] = input.nextInt();
            if(stock[productcount] >= 0) {
                break;
            }

            System.out.println("CANNOT BE NEGATIVE");
        }




        return productcount + 1;
    }





    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = 0;

        // arrays for product

        String[] productId = new String[100];
        String[] productName = new String[100];
        double[] price = new double[100];
        int[] stock = new int[100];
        int[] totalSold = new int[100];

        int productcount = 0;

        do {
            choice  = menu(choice, input);

            switch (choice) {
                case 1:
                    if (Check_Empty(productcount)) {
                        System.out.println("EMPTY. ADD FIRST");
                        break;
                    }

                    ViewProduct(productId, productName, price, stock, productcount);

                    break;
                case 2:
                    productcount = Addproduct(productId, productName, price, stock, productcount, input);
                    break;

                case 3:
                    if (Check_Empty(productcount)) {
                        System.out.println("EMPTY. ADD FIRST");
                        break;
                    }
                    break;
                case 4:
                    if (Check_Empty(productcount)) {
                        System.out.println("EMPTY. ADD FIRST");
                        break;
                    }
                    break;
                case 5:
                    if (Check_Empty(productcount)) {
                        System.out.println("EMPTY. ADD FIRST");
                        break;
                    }
                    break;
                case 6:
                    if (Check_Empty(productcount)) {
                        System.out.println("EMPTY. ADD FIRST");
                        break;
                    }
                    break;

                case 7:
                    if (Check_Empty(productcount)) {
                        System.out.println("EMPTY. ADD FIRST");
                        break;
                    }
                    break;

                case 8:
                    System.out.println("EXIT");
                    break;
                default:
                    System.out.println("INVALID INPUT");
                    break;
            }

        } while (choice != 8);

    }
}
