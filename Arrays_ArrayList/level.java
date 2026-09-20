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

        int choice = 0;

        int currentDay = 1;
        int currenthour = 16;
        int currentMinute = 0;
        String shopinfo = "";

       
        do { 
             if(currenthour >=  16) {
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
                        System.out.println((i+1) + ". " + productNames.get(i));
                    }
                    System.out.println("------------------------");
                    int productNumber = 0;

                    System.out.print("ENTER PRODUCT NUMBER: ");
                    productNumber = input.nextInt();

                    int restocknumber = 0;
                    System.out.print("ENTER RESTOCK QUANTITY: ");
                    restocknumber = input.nextInt();

                    stocks.set(productNumber - 1, stocks.get(productNumber - 1) + restocknumber);

                    break;

                case 5:
                    System.out.println("------------------------");
                    for (int i = 0; i < productNames.size(); i++) {
                        System.out.println((i+1) + ". " + productNames.get(i));
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

                    while(true) {
                    System.out.print("CURRENT DAY: ");
                    day = input.nextInt();
                    if(day > 0) {
                        break;
                    }
                    System.out.println("SHOULD BE GREATER THAN 0 ");
                    }

                    while(true) {
                    
                    System.out.print("CURRENT HOUR: ");
                    hour = input.nextInt();
                    System.out.print("CURRENT MINUTE: ");
                    minute = input.nextInt();
                        if((hour >= 0 && hour <= 24) && (minute >= 0 && minute <= 59)) {
                            break;
                        }

                        System.out.println("INVALID HOUR OR MINUTE");
                    }

                    currentDay = day;
                    currenthour = hour;
                    currentMinute = minute;

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