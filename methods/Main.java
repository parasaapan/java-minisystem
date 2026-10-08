
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
        System.out.println("6. Sell Product");
        System.out.println("7. Show Sales Report");
        System.out.println("8. EXIT");
        choice = input.nextInt();

        return choice;

    }

    public static void ADDPRODUCT(ArrayList<String> priceName, ArrayList<Double> priceProduct,
            ArrayList<Integer> productStocks, Scanner input) {
        
        String name = "";
        double price = 0;
        int stocks = 0;
                
        while(true) {
            boolean isblank = false;
            boolean isduplicate = false;

         System.out.println("PRODUCT NAME: ");  
         name = input.nextLine();

        if(name.trim().isBlank()) {
            isblank = true;
        }

        if(priceName.contains(name)){
            isduplicate = true;
        }

        if(isblank) {
            System.out.println("CANNOT BE BLANK");
        }

        if(isduplicate) {
            System.out.println("PRODUCT ALREADY EXISTING");
        }


        if(!isblank && !isduplicate) {
            break;
        }
            
        }


        

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<String> priceName = new ArrayList<>();
        ArrayList<Double> priceProduct = new ArrayList<>();
        ArrayList<Integer> productStocks = new ArrayList<>();

        int choice = 0;

        do {

            choice = Menu(input);

            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;

                case 4:

                    break;

                case 5:

                    break;

                case 6:

                    break;

                case 7:

                    break;

                case 8:

                    System.out.println("EXIT THANK U FOR USING");
                    break;

                default:
                    break;
            }

        } while (choice != 8);

        input.close();
    }
}
