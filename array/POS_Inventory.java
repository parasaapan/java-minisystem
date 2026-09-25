package array;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class POS_Inventory {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        ArrayList<String> productName = new ArrayList<>(Arrays.asList("Rice", "Bread", "Coke",
                "Milk", "Soap", "Shampoo"));
        ArrayList<Double> prices = new ArrayList<>(Arrays.asList(50.0, 45.0, 40.0, 95.0, 35.0, 120.0));

        ArrayList<Integer> stocks = new ArrayList<>(Arrays.asList(40, 30, 50, 40, 25, 20));

        ArrayList<String> categories = new ArrayList<>(Arrays.asList("Groccery", "Groccery", "Beverages", "Dairy",
                "Daily Necessities", "Daily Necessities"));

        ArrayList<String> voucherCodes = new ArrayList<>(Arrays.asList("SAVE 50", "SAVE 10", "SAVE 20", "NIGHT 15"));
        ArrayList<String> voucherType = new ArrayList<>(Arrays.asList("FLAT", "PERCENT", "PERCENT", "PERCENT"));
        ArrayList<Double> voucherValue = new ArrayList<>(Arrays.asList(50.0, 10.0, 20.0, 15.0));
        ArrayList<Double> voucherMinimums = new ArrayList<>(Arrays.asList(500.0, 1000.0, 2000.0, 1000.0));
        ArrayList<Boolean> voucherUsed = new ArrayList<>(Arrays.asList(false, false, false, false));

        String current_day = "";
        int currentHour = 0;
        int currentMinute = 0;

        System.out.println("======== STORE STARTUP ==========");
        
        // validating hour and minute
        while (true) {
            boolean isValid = false;
            System.out.print("Enter day: ");
            current_day = input.next();

            System.out.print("Enter hour: ");
            currentHour = input.nextInt();

            System.out.print("Enter minute: ");
            currentMinute = input.nextInt();

            if ((currentHour >= 0 && currentHour <= 23) && (currentMinute >= 0 && currentMinute <= 59)) {
                isValid = true;
            }

            if (isValid) {
                break;
            }

            System.out.println("INVALID MINUTE OR HOUR");
        }

        // overall
        int totalCustomers = 0;
        int totalPurchaseTransactions = 0;
        int totalReturnTransactions = 0;
        double totalSales = 0;
        double totalVAT = 0;
        double totalSpendingDiscount = 0;
        double totalTimeDiscount = 0;
        double totalVoucherDiscount = 0;
        double totalRefunds = 0;

        // daily
        int dailycustomers = 0;
        int dailypurchaseTransactions = 0;
        int dailyReturnTransactions = 0;

        double dailySales = 0;
        double dailyVAT = 0;
        double dailySpendingDiscount = 0;
        double dailyTimeDiscount = 0;
        double dailyVoucherDiscount = 0;
        double dailyRefunds = 0;

        int choice = 0;

        boolean isstoreoperating = true;
        int operatingdays = 1;

        while (isstoreoperating) {
            String Morning_AfterNoon = "";
            String Store_Status = "";
            boolean allowed_purchases = false;

            // PM or AM
            if (currentHour >= 12) {
                Morning_AfterNoon = "PM";
            } else if (currentHour >= 0) {
                Morning_AfterNoon = "AM";
            }

            if (currentHour >= 16 && currentHour <= 23) {
                Store_Status = "OPEN";
                allowed_purchases = true;
            } else {
                Store_Status = "CLOSED";
                allowed_purchases = false;
            }

            System.out.println("========= GROCERY STORE POS=========");
            System.out.println("OPERATING DAY: " + operatingdays);
            System.out.println("CURRENT TIME: " + currentHour + ":" + currentMinute + " " + Morning_AfterNoon);
            System.out.println("STORE STATUS: " + Store_Status);
            System.out.println();
            System.out.println();
            System.out.println("1. BUY PRODUCTS");
            System.out.println("2. RETURN PRODUCTS");
            System.out.println("3. VIEW PRODUCTS");
            System.out.println("4. ADD PRODUCT");
            System.out.println("5. VOUCHER INFORMATION");
            System.out.println("6. UPDATE STORE TIME");
            System.out.println("7. VIEW STORE INFORMATION");
            System.out.println("8. END DAY");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:

                    break;

                case 2:

                    break;

                case 3:
                    System.out.println("============AVAILABLE PRODUCTS=============");
                    for (int i = 0; i < productName.size(); i++) {
                        System.out.printf("%-2d. %-9s  %-9.2f  STOCK: %-9d  %-9s%n",
                                (i + 1),
                                productName.get(i),
                                prices.get(i),
                                stocks.get(i),
                                categories.get(i));
                    }
                    System.out.println("=============================================");
                    break;

                case 4:
                    String name;
                    double price_product = 0;
                    int stocks_product = 0;
                    String categoryu_product = "";

                    System.out.println("====== ADD PRODUCT======");
                    // enter product name
                    while (true) {
                            System.out.println("ENTER PRODUCT NAME: ");
                            name = input.nextLine();
                            if (!name.trim().isEmpty() && !productName.contains(name)) {
                                break;
                            }

                        System.out.println("NAME SHOULD BE UNIQUE AND NOT BLANK BLANK");
                    }

                    while (true) {
                        System.out.print("ENTER PRICE: ");
                        price_product = input.nextDouble();

                        if (price_product >= 0) {
                            break;
                        }

                        System.out.println("CANNOT BE LESS THAN 0");
                    }

                    while (true) {
                        System.out.println("ENTER STOCK: ");
                        stocks_product = input.nextInt();

                        if (stocks_product >= 0) {
                            break;
                        }

                        System.out.println("CANNOT BE LESS THAN 0");
                    }

                    while (true) {
                        System.out.println("ENTER CATEGORY: ");
                        categoryu_product = input.nextLine();

                        boolean match_category = false;

                        if (categories.contains(categoryu_product)) {
                            match_category = true;
                        }

                        if (match_category) {
                            break;
                        }

                        System.out.println("CATEGORY SHOULD BE GROCERIES, BEVERAGE, DAIRY, and DAILY NECESSITIES");

                    }

                    productName.add(name);
                    prices.add(price_product);
                    stocks.add(stocks_product);
                    categories.add(categoryu_product);

                    break;

                case 5:

                    break;

                case 6:
                    System.out.println("============UPDATE STORE TIME================");
                    while (true) {
                        boolean isValid = false;
                        System.out.print("Enter day: ");
                        current_day = input.next();

                        System.out.print("Enter hour: ");
                        currentHour = input.nextInt();

                        System.out.print("Enter minute: ");
                        currentMinute = input.nextInt();

                        if ((currentHour >= 0 && currentHour <= 23) && (currentMinute >= 0 && currentMinute <= 59)) {
                            isValid = true;
                        }

                        if (isValid) {
                            break;
                        }

                        System.out.println("INVALID MINUTE OR HOUR");
                    }
                    break;

                case 7:

                    break;

                case 8:

                    char Want_continue;
                    System.out.println("Do you waant to continue operating? (y/n)");
                    Want_continue = input.next().charAt(0);
                    if (Want_continue == 'n' || Want_continue == 'N') {
                        isstoreoperating = false;

                    } else {
                        operatingdays++;
                    }
                    break;

                default:
                    System.out.println("INVALID INPUT");
                    break;
            }
        }

        input.close();
    }
}
