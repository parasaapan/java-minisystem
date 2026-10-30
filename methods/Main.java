
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static int Menu(Scanner input) {
        int choice = 0;

        System.out.println("\n======= CONVENIENCE STORE =========");
        System.out.println("1. Add Product");
        System.out.println("2. View Product");
        System.out.println("3. Search Product");
        System.out.println("4. Update Stock");
        System.out.println("5. Sell Product");
        System.out.println("6. Remove Product");
        System.out.println("7. Show Sales Report");
        System.out.println("8. EXIT");
        System.out.print("CHOICE: ");
        choice = input.nextInt();

        input.nextLine();

        return choice;

    }

    public static void ADDPRODUCT(ArrayList<String> productName, ArrayList<Double> priceProduct,
            ArrayList<Integer> productStocks, Scanner input) {

        String name = "";
        double price = 0;
        int stocks = 0;

        while (true) {
            boolean isblank = false;
            boolean isduplicate = false;

            System.out.print("PRODUCT NAME: ");
            name = input.nextLine();

            if (name.trim().isBlank()) {
                isblank = true;
            }

            if (productName.contains(name)) {
                isduplicate = true;
            }

            if (isblank) {
                System.out.println("CANNOT BE BLANK");
            }

            if (isduplicate) {
                System.out.println("PRODUCT ALREADY EXISTING");
            }

            if (!isblank && !isduplicate) {
                break;
            }

        }

        while (true) {
            System.out.print("ENTER PRODUCT PRICE: ");
            price = input.nextDouble();

            if (price > 0) {
                break;
            }

            System.out.println("PRICE CANNOT BE NEGATIVE OR 0");
        }

        while (true) {
            System.out.print("ENTER STOCKS OF PRODUCT: ");
            stocks = input.nextInt();

            if (stocks > 0) {
                break;
            }

            System.out.println("STOCKS CANNOT BE NEGATIVE OR ZERO");
        }

        productName.add(name);
        priceProduct.add(price);
        productStocks.add(stocks);

    }

    public static void ViewAllProduct(ArrayList<String> productName, ArrayList<Double> priceProduct,
            ArrayList<Integer> productStocks) {

        if (productName.isEmpty()) {
            System.out.println("EMPTY PRODUCT ADD FIRST");
            return;
        }

        System.out.println("============== PRODUCTS ===============");

        System.out.printf("%-5s %-15s %-10s %-12s%n",
                "NUM",
                "PRODUCT NAME",
                "PRICE",
                "STOCKS");

        for (int i = 0; i < productName.size(); i++) {
            System.out.printf("%-5d %-15s %-10.2f %-12d%n",
                    (i + 1),
                    productName.get(i),
                    priceProduct.get(i),
                    productStocks.get(i));
        }

    }

    public static void SearchProduct(ArrayList<String> productName, ArrayList<Double> priceProduct,
            ArrayList<Integer> productStocks, Scanner input) {

        if (productName.isEmpty()) {
            System.out.println("EMPTY LIST ADD FIRST");
            return;
        }

        String nametoSearch = "";

        System.out.print("ENTER PRODUCT NAME: ");
        nametoSearch = input.nextLine();

        for (int i = 0; i < productName.size(); i++) {
            if (nametoSearch.equalsIgnoreCase(productName.get(i))) {
                System.out.println("PRODUCT FOUND!");
                System.out.println("NAME: " + productName.get(i));
                System.out.println("PRICE: " + priceProduct.get(i));
                System.out.println("AVAILABLE STOCKS: " + productStocks.get(i));

                break;
            }

            System.out.println("PRODUCT DID NOT FOUND");
        }

    }

    public static void UpdateStocks(ArrayList<String> productName, ArrayList<Integer> productStocks,
            Scanner input) {
        if (productName.isEmpty()) {
            System.out.println("EMPTY LIST");
            return;
        }

        int num = 0;

        System.out.print("ENTER NUMBER OF PRODUCT YOU WANT TO UPDATE: ");
        num = input.nextInt();

        if (num <= 0) {
            System.out.println("INVALID");
            return;
        }

        int addStocks = 0;

        System.out.println("NAME: " + productName.get(num - 1));
        System.out.println("CURRENT STOCKS: " + productStocks.get(num - 1));

        System.out.print("ADD STOCKS: ");
        addStocks = input.nextInt();

        if (addStocks <= 0) {
            System.out.println("INVALID NUMBER ");
            return;
        }

        productStocks.set(num - 1, productStocks.get(num - 1) + addStocks);

        System.out.println("===================");
        System.out.println("UPDATED STOCKS: " + productStocks.get(num - 1));

    }

    public static int SellProduct(ArrayList<Integer> productStocks, Scanner input, ArrayList<String> productName,
            ArrayList<Double> priceProduct, ArrayList<Double> sales) {

        if (productStocks.isEmpty()) {
            System.out.println("CANNOT SALES PRODUCT LIST IS EMPTY");
            return 0 ;
            
        }

        String name = "";
        boolean isfound = false;
        int index = 0;

        System.out.print("ENTER PRODUCT NAME: ");
        name = input.nextLine();

        for (int i = 0; i < productStocks.size(); i++) {
            if (name.equalsIgnoreCase(productName.get(i))) {
                index = i;
                isfound = true;
                break;
            }
        }

        if (!isfound) {
            System.out.println("PRODUCT NOT FOUND");
            return 0;
        }

        System.out.print("QUANTITY TO SELL: ");
        int quantity = input.nextInt();

        if (quantity <= 0 || quantity > productStocks.get(index)) {
            System.out.println("INVALID");
            System.out.println("CANNOT BE GREATER THAN STOCKS OR CANT BE LESS THAN 0!!");
            return 0;
        }

        double subtotal = quantity * priceProduct.get(index);

        productStocks.set(index, productStocks.get(index) - quantity);

        sales.add(subtotal);

        System.out.println("======= RECEIPT =======");

        System.out.println("PRODUCT: " + productName.get(index));
        System.out.println("QUANTITY: " + quantity);
        System.out.println("PRICE: " + priceProduct.get(index));
        System.out.println("SUBTOTAL: " + subtotal);

        System.out.println();
        System.out.println("SALE SUCCESSFUL");
        System.out.println("REMAINING STOCK: " + productStocks.get(index));

        if (productStocks.get(index) == 0) {
            productName.remove(index);
            productStocks.remove(index);
            priceProduct.remove(index);
        }


        return 1;

    }



    public static void RemoveProduct(ArrayList<String> productName, ArrayList<Double> priceProduct,
            ArrayList<Integer> productStocks, Scanner input) {
                if(productName.isEmpty()) {
                    System.out.println("EMPTY LIST");
                    return;
                }

                String name = "";   

                System.out.print("ENTER NAME: ");
                name = input.nextLine();

                for(int i = 0 ; i < productName.size(); i++) {
                    if(name.equalsIgnoreCase(productName.get(i))) {
                        productName.remove(i);
                        productStocks.remove(i);
                        priceProduct.remove(i);
                        System.out.println("--SUCCESFULLY REMOVE--");
                        return;
                    }
                }

                System.out.println("PRODUCT DID NOT FOUND");
                
            }


    public static void ReportSales(ArrayList<Double> sales, int totalTransactions) {
        if(sales.isEmpty()) {
            System.out.println("NO TRANSACTIONS");
            return;
        }

        double totalRevenue = 0;

        double highestSale = sales.get(0);
        double lowestSale = sales.get(0);

        for(int i = 0 ; i < sales.size(); i++) {
            totalRevenue += sales.get(i);

            if(sales.get(i) > highestSale) {
                highestSale = sales.get(i);
            }

            if(sales.get(i) < lowestSale) {
                lowestSale = sales.get(i);
            }


        }

        double averageSale = totalRevenue / totalTransactions;

        System.out.println("==================== SALES REPORT ========================");
        System.out.println("TOTAL TRANSACTIONS: " + totalTransactions);
        System.out.println("TOTAL REVENUE: " + totalRevenue);

        System.out.println();
        System.out.println("HIGHEST SALE: " + highestSale);
        System.out.println("LOWEST SALE: " + lowestSale);
        System.out.println("AVERAGE SALE: " + averageSale);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<String> productName = new ArrayList<>();
        ArrayList<Double> priceProduct = new ArrayList<>();
        ArrayList<Integer> productStocks = new ArrayList<>();

        ArrayList<Double> sales = new ArrayList<>();

        int totalTransactions = 0;

        int choice = 0;

        do {

            choice = Menu(input);

            switch (choice) {
                case 1:
                    ADDPRODUCT(productName, priceProduct, productStocks, input);
                    break;
                case 2:
                    ViewAllProduct(productName, priceProduct, productStocks);
                    break;
                case 3:
                    SearchProduct(productName, priceProduct, productStocks, input);
                    break;

                case 4:
                    ViewAllProduct(productName, priceProduct, productStocks);
                    UpdateStocks(productName, productStocks, input);
                    break;

                case 5:
                   totalTransactions += SellProduct(productStocks, input, productName, priceProduct, sales);
                    break;

                case 6:
                    RemoveProduct(productName, priceProduct, productStocks, input); 
                    break;

                case 7:
                    ReportSales(sales, totalTransactions);
                    break;

                case 8:

                    System.out.println("EXIT THANK U FOR USING");
                    break;

                default:
                    System.out.println("INVALID CHOICE");
                    break;
            }

        } while (choice != 8);

        input.close();
    }
}
