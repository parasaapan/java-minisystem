package Arrays_ArrayList;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class level {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> productNames = new ArrayList<>(
                Arrays.asList("Rice", "Bread", "Coke", "Milk", "Soap", "Shampoo"));

        ArrayList<Double> prices = new ArrayList<>(Arrays.asList(50.0, 45.0, 40.0, 95.0, 35.0, 120.0));

        ArrayList<Integer> stocks = new ArrayList<>(Arrays.asList(40, 30, 50, 40, 25, 20));

        ArrayList<String> category = new ArrayList<>(
                Arrays.asList("Grocery", "Grocery", "Beverages", "Dairy", "Daily Necessities", "Daily Necessities"));

        ArrayList<Integer> dailySoldQuantities = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0));

        // list for the tempCart store when the originall stock will be store

        ArrayList<Integer> tempCartStore = new ArrayList<>();
        tempCartStore.addAll(stocks);

        ArrayList<Integer> cartProductIndexes = new ArrayList<>();
        ArrayList<Integer> cartQuantities = new ArrayList<>();

        int choice = 0;

        int currentDay = 1;
        int currenthour = 16;
        int currentMinute = 0;
        String shopinfo = "";

        double subTotal = 0;

        double payment = 0;
        double change = 0;

        do {
            if (currenthour >= 16) {
                shopinfo = "OPEN";
            } else {
                shopinfo = "CLOSED";
            }

            System.out.println("---------------STORE INFO----------------");
            System.out.println("CURRENT DAY: " + currentDay);
            System.out.println("CURRENT TIME: " + currenthour + ":" + currentMinute);
            System.out.println("SHOP INFO: " + shopinfo);
            System.out.println("-----------------------------------------");
            System.out.println();
            System.out.println("1.DISPLAY INVENTORY");
            System.out.println("2.ADD PRODUCT");
            System.out.println("3.SEARCH PRODUCT");
            System.out.println("4.RESTOCK");
            System.out.println("5.UPDATE PRODUCT");
            System.out.println("6.UPDATE STORE TIME");
            System.out.println("7.BUY PRODUCT");
            System.out.println("8.PAYMENT");
            System.out.println("9 EXIT");
            System.out.print("ENTER CHOICE: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("=========================INVENTORY========================");
                    for (int i = 0; i < productNames.size(); i++) {
                        System.out.printf("%-3d %-15s %-9.2f STOCK:%-7d %-19s SOLD: %-5d%n",
                                i + 1,
                                productNames.get(i),
                                prices.get(i),
                                stocks.get(i),
                                category.get(i),
                                dailySoldQuantities.get(i));
                    }
                    break;

                case 2:

                    String name;
                    double price;
                    int stock;
                    String Category;

                    while (true) {
                        int isValid = 0;
                        System.out.print("Product name: ");
                        name = input.nextLine();

                        if (!name.trim().isEmpty()) {
                            isValid++;
                        }

                        if (!productNames.contains(name)) {
                            isValid++;
                        }

                        boolean isfound = false;
                        for (String found : productNames) {
                            if (found.equalsIgnoreCase(name)) {
                                isfound = true;
                                break;
                            }
                        }

                        if (!isfound) {
                            isValid++;
                        }

                        if (isValid == 3) {
                            break;
                        }

                        System.out.println("NAME SHOULD NOT BE DUPLICATE OR SHOULD NOT BE BLANK");
                    }

                    while (true) {
                        System.out.print("Price: ");
                        price = input.nextDouble();

                        if (price > 0) {
                            break;
                        }

                        System.out.println("PRICE SHOULD NOT BE LESS THAN 0");
                    }

                    while (true) {
                        System.out.print("STOCK: ");
                        stock = input.nextInt();

                        if (stock >= 0) {
                            break;
                        }

                        System.out.println("STOCK SHOULD BE GREATER THAN OR EQUAL TO ZERO");
                    }

                    while (true) {

                        System.out.println("CATEGORY: ");
                        Category = input.nextLine();

                        if (!Category.trim().isEmpty() && category.contains(Category)) {
                            break;
                        }

                        System.out.println("INVALID INPUT");
                    }

                    productNames.add(name);
                    prices.add(price);
                    stocks.add(stock);
                    category.add(Category);
                    dailySoldQuantities.add(0);
                    // for cart
                    tempCartStore.add(stock);

                    break;

                case 3:
                    System.out.print("ENTER NAME: ");
                    String nametoSearch = input.nextLine();
                    boolean isfound = false;
                    int index = 0;
                    for (int i = 0; i < productNames.size(); i++) {
                        if (productNames.get(i).equalsIgnoreCase(nametoSearch)) {
                            isfound = true;
                            index = i;
                            break;
                        }
                    }

                    if (isfound) {
                        System.out.println();
                        System.out.println();
                        System.out.println("PRODUCT FOUND!!!!!!!!!!!");
                        System.out.println("NAME: " + productNames.get(index));
                        System.out.println("PRICE: " + prices.get(index));
                        System.out.println("STOCK: " + stocks.get(index));
                        System.out.println("CATEGORY: " + category.get(index));
                        System.out.println();
                    } else {
                        System.out.println("NOT FOUND");
                        System.out.println();
                    }

                    break;

                case 4:

                    System.out.println("------------------------");
                    for (int i = 0; i < productNames.size(); i++) {
                        System.out.println((i + 1) + ". " + productNames.get(i));
                    }
                    System.out.println("------------------------");
                    int productNumber = 0;

                    System.out.print("ENTER PRODUCT NUMBER: ");
                    productNumber = input.nextInt();

                    int restocknumber = 0;
                    System.out.print("ENTER RESTOCK QUANTITY: ");
                    restocknumber = input.nextInt();

                    stocks.set(productNumber - 1, stocks.get(productNumber - 1) + restocknumber);
                    tempCartStore.set(productNumber - 1, stocks.get(productNumber - 1) + restocknumber);
                    break;

                case 5:
                    System.out.println("------------------------");
                    for (int i = 0; i < productNames.size(); i++) {
                        System.out.println((i + 1) + ". " + productNames.get(i));
                    }
                    System.out.println("------------------------");
                    int productnumber = 0;
                    System.out.print("ENTER PRODUCT NUMBER: ");
                    productnumber = input.nextInt();

                    System.out.println("OLD PRICE: " + prices.get(productnumber - 1));
                    double newprice = 0;
                    while (true) {
                        System.out.print("NEW PRICE: ");
                        newprice = input.nextDouble();

                        if (newprice > 0) {
                            break;
                        }

                        System.out.println("SHOULD NOT BE LESS THAN ZERO");
                    }

                    prices.set(productnumber - 1, newprice);

                    break;

                case 6:
                    int day = 0;
                    int hour = 0;
                    int minute = 0;

                    while (true) {
                        System.out.print("CURRENT DAY: ");
                        day = input.nextInt();
                        if (day > 0) {
                            break;
                        }
                        System.out.println("SHOULD BE GREATER THAN 0 ");
                    }

                    while (true) {

                        System.out.print("CURRENT HOUR: ");
                        hour = input.nextInt();
                        System.out.print("CURRENT MINUTE: ");
                        minute = input.nextInt();
                        if ((hour >= 0 && hour <= 24) && (minute >= 0 && minute <= 59)) {
                            break;
                        }

                        System.out.println("INVALID HOUR OR MINUTE");
                    }

                    currentDay = day;
                    currenthour = hour;
                    currentMinute = minute;

                    break;

                case 7:
                    double subtotalCart = 0;

                    int productnum = 0; // this is when the user enter the product name
                    System.out.println("\n--------------------------");
                    for (int i = 0; i < productNames.size(); i++) { // this is for the product name to be printed
                        System.out.printf("%-1s %-11s %-10.2f%n",
                                i + 1,
                                productNames.get(i),
                                prices.get(i));

                    }
                    System.out.println("-----------------------------");

                    while (true) {
                        System.out.print("ENTER PRODUCT NUMBER: "); // user will enter product number
                        productnum = input.nextInt();

                        if (productnum >= 1 && productnum <= productNames.size()) {
                            break;
                        }

                        System.out.println("INVALID PRODUCT NUMBER TRY AGAIN\n");
                    }

                    boolean isduplicate = false; // this boolean is to check if the product is duplicate

                    int QUANTITY = 0; // quantity to be enter

                    while (true) {
                        System.out.print("ENTER QUANTITY: ");
                        QUANTITY = input.nextInt();

                        if (QUANTITY > 0 && QUANTITY <= tempCartStore.get(productnum - 1)) { // the tmepcart store will
                                                                                             // store the stocks in a
                                                                                             // cart temp storage
                            break;
                        }

                        System.out.println("CANNOT BE NEGATIVE AND CCANNOT BE GREATER THAN TLHE STOCKS\n" +
                                "CURRENT STOCKS " + tempCartStore.get(productnum - 1));

                    }

                    // adding the cartquantities if its duplicate
                    for (int i = 0; i < cartProductIndexes.size(); i++) {
                        if (cartProductIndexes.get(i) == productnum - 1) {
                            cartQuantities.set(i, cartQuantities.get(i) + QUANTITY);
                            isduplicate = true;
                        }
                    }
                    // iifi not duplicate add another set of product in the cart
                    if (!isduplicate) {
                        cartProductIndexes.add(productnum - 1);
                        cartQuantities.add(QUANTITY);

                    }
                    // the productnum -1 is for us to access the original index
                    tempCartStore.set(productnum - 1, tempCartStore.get(productnum - 1) - QUANTITY);

                    System.out.println("\n==========================");
                    System.out.printf("%-11s %-11s %-11s%n",
                            "PRODUCT", "QUANTITY", "PRICE");
                    for (int i = 0; i < cartProductIndexes.size(); i++) {
                        System.out.printf("%-11s %-11d %-11.2f%n",
                                productNames.get(cartProductIndexes.get(i)),
                                cartQuantities.get(i),
                                prices.get(cartProductIndexes.get(i))

                        );
                        // compute the subtotal then add it to the subtotal per index

                        subtotalCart += prices.get(cartProductIndexes.get(i)) * QUANTITY;

                    }
                    System.out.println("==============================");
                    System.out.println("SUBTOTAL: " + subtotalCart);
                    break;

                case 8:
                    if (cartProductIndexes.isEmpty()) {
                        System.out.println("CART IS EMPTY");
                        System.out.println("CANNOT PROCEED TO PAYMENT");
                        break;
                    }

                    if (shopinfo.equals("CLOSED")) {
                        System.out.println("SHOP IS CLOSED.");
                        System.out.println("CANNOT PROCEED TO PAYMENT");
                        break;
                    }

                    subTotal = 0; // each time the product go in this the subtotal will be reset at zero
                    // instead of adding it infinite

                    for (int i = 0; i < cartProductIndexes.size(); i++) {
                        subTotal += prices.get(cartProductIndexes.get(i)) * cartQuantities.get(i);
                    }

                    for (int i = 0; i < cartProductIndexes.size(); i++) {
                        System.out.printf("%-12s x %-2d = %-10.2f%n",
                                productNames.get(cartProductIndexes.get(i)),
                                cartQuantities.get(i),
                                prices.get(cartProductIndexes.get(i)) * cartQuantities.get(i));
                    }

                    System.out.println("--------------------------------------");
                    System.out.println("SUBTOTAL = " + subTotal);

                    System.out.println("========== PAYMENT ===========");
                    while (true) {
                        System.out.print("ENTER PAYMENT: ");
                        payment = input.nextDouble();
                        if (payment >= subTotal) {
                            System.out.println("SUCCESS FULL PAYMENT");
                            break;
                        }

                        System.out.println("INVALID PAYMENT");

                    }

                    change = payment - subTotal;

                    System.out.println("YOUR CHANGE: " + change);


                    // update the daily sold
                    for(int i = 0 ; i < cartProductIndexes.size(); i ++) {
                        dailySoldQuantities.set(cartProductIndexes.get(i), dailySoldQuantities.get(cartProductIndexes.get(i)) + cartQuantities.get(i));
                    } 

                   for(int i = 0 ; i < cartProductIndexes.size(); i++) {
                    stocks.set(cartProductIndexes.get(i), stocks.get(cartProductIndexes.get(i)) - cartQuantities.get(i) );
                   }
                     
                    cartProductIndexes.clear();
                    cartQuantities.clear();
                    
                    break;
                case 9:
                    System.out.println("EXiT");
                    break;

                default:
                    break;
            }

        } while (choice != 9);

        input.close();
    }
}