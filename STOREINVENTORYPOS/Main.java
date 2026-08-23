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

        while (true) {
            System.out.print("ENTER PRODUCT NAME: ");
            productName[productcount] = input.nextLine();

            if (productName[productcount] != "") {
                break;
            }

            System.out.println("PRODUCT NAME CANNOT BE EMPTY");
        }

        while (true) {
            System.out.print("ENTER PRICE OF THIS PRODUCT: ");
            price[productcount] = input.nextDouble();
            if (price[productcount] > 0) {
                break;
            }

            System.out.println("CANNOT BE NEGATIVE");
        }

        while (true) {
            System.out.print("ENTER STOCK OF THIS PRODUCT: ");
            stock[productcount] = input.nextInt();
            if (stock[productcount] >= 0) {
                break;
            }

            System.out.println("CANNOT BE NEGATIVE");
        }

        return productcount + 1;
    }

    // search product

    public static int Search_submenu(int searcchoice) {

        System.out.println("1. SEARCH BY ID");
        System.out.println("2. SEARCH BY NAME");
        System.out.println("3. BACK");

        return searcchoice;
    }

    // SEARCH BY ID

    public static void Searchby_ID(String[] productId, String[] productName, double[] price, int[] stock,
            int productcount, Scanner input) {
        String id;
        boolean isfound = false;

        System.out.println("ENTER PRODUCT ID");
        id = input.next();

        for (int i = 0; i < productcount; i++) {
            if (id.equals(productId[i])) {
                System.out.println("PRODUCT FOUND");
                System.out.println("NAME: " + productName[i]);
                System.out.println("PRICE: " + price[i]);
                System.out.println("STOCKS: " + stock[i]);
                isfound = true;
                break;
            }
        }

        if (!isfound) {
            System.out.println("NOT FOUND");
        }
    }

    // SEARCH BY NAME

    public static void Searchby_Name(String[] productId, String[] productName, double[] price, int[] stock,
            int productcount, Scanner input) {
        String name;
        boolean isfound = false;

        input.nextLine();

        System.out.println("ENTER PRODUCT NAME");
        name = input.nextLine();

        for (int i = 0; i < productcount; i++) {
            if (name.equalsIgnoreCase(productName[i])) {
                System.out.println("PRODUCT FOUND");
                System.out.println("ID: " + productName[i]);
                System.out.println("PRICE: " + price[i]);
                System.out.println("STOCKS: " + stock[i]);
                isfound = true;
                break;
            }
        }

        if (!isfound) {
            System.out.println("NOT FOUND");
        }
    }

    // reStock product

    public static void ReStock(int[] stock, String[] productId, int productcount, Scanner input) {
        String id;
        boolean isfound = false;
        int productadd = 0;
        int index = 0;

        System.out.println("ENTER PRODUCT ID");
        id = input.next();

        for (int i = 0; i < productcount; i++) {
            if (id.equals(productId[i])) {
                System.out.println("PRODUCT FOUND");
                System.out.println("CURRENT STOCKS: " + stock[i]);
                index = i;
                isfound = true;
                break;
            }
        }

        if (!isfound) {
            System.out.println("NOT FOUND");
        } else {
            while (true) {
                System.out.print("ENTER QUANTITY TO ADD: ");
                productadd = input.nextInt();
                if (productadd > 0) {
                    stock[index] += productadd;
                    break;
                }

                System.out.println("NO NEGATIVE VALLUE");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = 0;

        int searchchoice = 0;

        // arrays for product

        String[] productId = new String[100];
        String[] productName = new String[100];
        double[] price = new double[100];
        int[] stock = new int[100];

        int productcount = 0;

        do {
            choice = menu(choice, input);

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

                    searchchoice = Search_submenu(searchchoice);
                    if (searchchoice == 1) {
                        Searchby_ID(productId, productName, price, stock, productcount, input);
                    } else if (searchchoice == 2) {
                        Searchby_Name(productId, productName, price, stock, productcount, input);
                    } else if (searchchoice == 3) {
                        break;
                    } else {
                        System.out.println("INVALID INPUT ");
                        break;
                    }
                    break;
                case 4:
                    if (Check_Empty(productcount)) {
                        System.out.println("EMPTY. ADD FIRST");
                        break;
                    }

                    ReStock(stock, productId, productcount, input);

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
