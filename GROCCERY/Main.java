import java.util.Scanner;

public class Main {

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

    public static int AddtoCart(Scanner input, int cartcount, String[] CarTProduct, double[] priceCart,
            int[] QuantityCart, String[] ProductName, int[] Stocks, double[] Price) {

        int id = 0;
        int quantity = 0;
        int shouldcount = 0;

        do {

            System.out.println("ENTER ID: ");
            id = input.nextInt();
            if (id < 0 || id > ProductName.length - 1) {
                System.out.println("INVALID ID");
            }

        } while (id < 0 || id > ProductName.length - 1);
        boolean istrue = false;
        // check if existing na sa cart
        for (int i = 0; i < cartcount; i++) {
            if (ProductName[id].equalsIgnoreCase(CarTProduct[i])) {

                System.out.println("EXISTING PRODUCT");
                while (true) {
                    System.out.println("ENTER QUANTITY TO ADD: ");
                    quantity = input.nextInt();
                    if (quantity > 0 && quantity <= Stocks[id]) {
                        break;
                    }
                }
                QuantityCart[i] += quantity;
                Stocks[id] -= quantity;
                istrue = true;
                break;
            }

        }

        if (!istrue) {
            while (true) {
                System.out.println("ENTER QUANTITY: ");
                quantity = input.nextInt();
                if (quantity > 0 && quantity <= Stocks[id]) {
                    break;
                }
            }
            CarTProduct[cartcount] = ProductName[id];
            QuantityCart[cartcount] = quantity;
            priceCart[cartcount] = Price[id];
            Stocks[id] -= quantity;
            shouldcount++;

        }

        return shouldcount;

    }

    public static void ShowCart(String[] CarTProduct, int[] QuantityCart, double[] priceCart, int cartcount) {
        System.out.println("==== CART ====");
        System.out.printf("%-5s %-15s %-10s %-10s %-10s%n", "ID", "PRODUCT", "QTY", "PRICE", "SUBTOTAL");
        for (int i = 0; i < cartcount; i++) {
            System.out.printf("%-5d %-15s %-10d %-10.2f %-10.2f%n", i,
                    CarTProduct[i], QuantityCart[i], priceCart[i], (QuantityCart[i] * priceCart[i]));
        }
    }

    public static int Deleteitem(Scanner input, int cartcount, String[] CarTProduct, int[] QuantityCart,
            double[] priceCart, int[] Stocks) {
        int id = 0;
        int cartMinus = cartcount;
        System.out.println("ENTER ID TO REMOVE: ");
        id = input.nextInt();
        if (id < 0 || id > cartcount - 1) {
            System.out.println("ITEM NOT FOUND");

        } else {

            int quantity = 0;

            while (true) {
                System.out.println("ENTER QUANTITY TO REMOVE");
                quantity = input.nextInt();
                if (quantity <= QuantityCart[id] && quantity >= 0) {
                    QuantityCart[id] -= quantity;
                    Stocks[id] += quantity;
                    System.out.println("ITEM UPDATE: " + QuantityCart[id]);
                    break;
                }
            }

            if (QuantityCart[id] == 0) {
                for (int i = id; i < cartcount - 1; i++) {
                    CarTProduct[i] = CarTProduct[i + 1];
                    QuantityCart[i] = QuantityCart[i + 1];
                    priceCart[i] = priceCart[i + 1];
                }

                cartMinus--;
            }

        }
        return cartMinus;

    }

    public static int Checkout(Scanner input, int cartcount, int[] QuantityCart, double[] priceCart,
            String[] CarTProduct) {
            int cart = 0;
                if(cartcount == 0) {
                    System.out.println("EMPTY CART");
                    cart = cartcount;
                    
                } else {
        System.out.println("== CHECKOUT ==");

        double total = 0;
        for (int i = 0; i < cartcount; i++) {
            total += (QuantityCart[i] * priceCart[i]);
        }
        System.out.println("TOTAL PRICE : " + total);

        double money = 0;
        double discout = 0;
        double change = 0;
        double subtotal = total;

        while (true) {
            System.out.print("ENTER YOUR MONEY : ");
            money = input.nextDouble();
            if (money > 0 && money >= total) {

                if (total >= 2000) {
                    discout = total * 0.10;
                    total = total - discout;
                } else if (total >= 1000) {
                    discout = total * 0.05;
                    total = total - discout;
                }

                change = money - total;

                break;

            }

            System.out.println("INVALID PAYMENT TRY AGAIN.");
        }

        System.out.println("=== RECEIPT ===");
        System.out.println("");
        for (int i = 0; i < cartcount; i++) {
            System.out.printf("%-15s %-10.2f%n", CarTProduct[i], priceCart[i] * QuantityCart[i]);
        }

        System.out.println("");
        System.out.println("");
        System.out.printf("%-15s %-10.2f%n", "SUBTOTAL: ", subtotal);
        System.out.printf("%-15s %-10.2f%n", "DISCOUNT: ", discout);
        System.out.printf("%-15s %-10.2f%n", "TOTAL: ", total);

        System.out.println("");
        System.out.println("");
        System.out.printf("%-15s %-10.2f%n", "CASH: ", money);
        System.out.printf("%-15s %-10.2f%n", "CHANGE: ", change);

        cart = 0;

    }

    return cart;

    }

    public static boolean CheckCart(int cartcount) {
        if(cartcount == 0) {
            return true;
        } else {
            return false;
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

        do {
            menu();
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    ViewProducts(ProductName, Price, Stocks);
                    break;
                case 2:
                    ViewProducts(ProductName, Price, Stocks);
                    cartcount += AddtoCart(input, cartcount, CarTProduct, priceCart, QuantityCart, ProductName, Stocks,
                            Price);

                    break;

                case 3:
                    ShowCart(CarTProduct, QuantityCart, priceCart, cartcount);
                    cartcount = Deleteitem(input, cartcount, CarTProduct, QuantityCart, priceCart, Stocks);
                    break;

                case 4:
                    if(CheckCart(cartcount)) {
                        break;
                    } 
                    ShowCart(CarTProduct, QuantityCart, priceCart, cartcount);
                    break;

                case 5:
                cartcount = Checkout(input, cartcount, QuantityCart, priceCart, CarTProduct);
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