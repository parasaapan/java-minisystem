import java.util.Scanner;

import javax.print.attribute.standard.PrinterIsAcceptingJobs;

public class methods {

    public static void menu() {
        System.out.println("===== GROCERY POS ===== ");
        System.out.println("1. View Products");
        System.out.println("2. Add Item to the Cart");
        System.out.println("3. Remove Item from Cart");
        System.out.println("4. View Cart");
        System.out.println("5. Checkout");
        System.out.println("6. Exit");

        System.out.print("ENTER CHOICE: ");
    }

    public static void ViewProducts(String[] ProductName, double[] Price, int[] Stocks) {
        System.out.println("=== PRODUCTS ===");
        System.out.printf("%-5s %-15s %-10s %-10s%n",
                "ID", "PRODUCT", "PRICE", "STOCKS");
        for (int i = 0; i < ProductName.length; i++) {
            System.out.printf("%-5d %-15s %-10.2f %-10d%n",
                    i, ProductName[i], Price[i], Stocks[i]);
        }
    }

    public static int AddtoCart(Scanner input, String[] ProductName, int[] Stocks,int index) {

        int quantity = 0;


        do {
            System.out.println("ENTER QUANTITY: ");
            quantity = input.nextInt();
            if (quantity < 0) {
                System.out.println("CANNOT ENTER LESS THAN ZERO");
            }

            if (quantity > Stocks[index]) {
                System.out.println("NOT ENOUGH STOCKS");
                System.out.println("AVAILABLE STOCKS: " + Stocks[index]);
            }

        } while (quantity < 0 || quantity > Stocks[index]);

        return quantity;
    }


    public static int ReturnTHeIndex (Scanner input, String[] ProductName) {

        int index = 0;
        
            while (true) {
            System.out.print("ENTER ID PRODUCT: ");
            index = input.nextInt();
            if (index >= 0 && index <= ProductName.length - 1) {
                break;
            }
            System.out.println("INVALID ID");
        }

        return index;
    }

    public static void ShowCart(String[] CarTProduct, int[] QuantityCart, double[] priceCart, int cartcount) {
        System.out.println("==== CART ====");
        System.out.printf("%-15s %-10s %-10s %-10s%n", "PRODUCT","QTY","PRICE","SUBTOTAL");
        for(int i = 0; i < cartcount; i++) {
            System.out.printf("%-15s %-10d %-10.2f %-10.2f%n", 
                CarTProduct[i],QuantityCart[i],priceCart[i],(QuantityCart[i] * priceCart[i])
            );
        }
    } 

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // main product
        String[] ProductName = { "Rice", "Milk", "Oats", "Egg", "3 in 1 Coffee", "Ketchup", "Ice", "Bread", "Chicken" };
        double[] Price = { 50, 100, 40, 10, 15, 15, 5, 45, 100 };
        int[] Stocks = { 50, 50, 50, 100, 20, 50, 50, 50, 50 };

        // array for cart
        int cartcount = 0;

        String[] CarTProduct = new String[20];
        int[] QuantityCart = new int[20];
        double[] priceCart = new double[20];

        int choice = 0;

        int index = 0;

        do {
            menu();
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    ViewProducts(ProductName, Price, Stocks);
                    break;
                case 2:
                    ViewProducts(ProductName, Price, Stocks);
                    index = ReturnTHeIndex(input, ProductName);
                    QuantityCart[cartcount] += AddtoCart(input, ProductName, Stocks, index);
                    CarTProduct[cartcount] = ProductName[index]; 
                    priceCart[cartcount] = Price[index];
                    cartcount++;
                    break;

                case 3:
                    ShowCart(CarTProduct, QuantityCart, priceCart, cartcount);
                    break;

                case 4:

                    break;

                case 5:

                    break;

                case 6:
                    System.out.println("EXITTING");
                    break;

                default:
                    System.out.println("INVALID INPUT");
                    break;
            }
        } while (choice != 6);

        input.close();
    }

}
