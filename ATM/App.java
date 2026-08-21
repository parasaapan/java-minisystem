package ATM;
import java.util.Scanner;

public class App{

    public static int setupPin(Scanner input) {
        int validPin = 0;

        while (true) {
            System.out.print("ENTER PIN: ");
            validPin = input.nextInt();
            if (validPin >= 1000 && validPin <= 9999) {
                break;
            }

            System.out.println("INVALID PIN");
        }

        return validPin;
    }

    public static double setUpBalance(Scanner input) {
        double initialBalance = 0;

        while (true) {
            System.out.print("ENTER INITIAL BALANCE: ");
            initialBalance = input.nextDouble();
            if (initialBalance > 0) {
                break;
            }

            System.out.println("INVALID BALANCE");
        }

        return initialBalance;
    }

    public static void approve(int PIN, double balance) {
        System.out.println("------ ACCOUNT APPROVE ------");
        System.out.println("PIN: " + PIN);
        System.out.println("BALANCE: " + balance);
    }

    public static void menu() {
        System.out.println("==== ATM ====");
        System.out.println("1. DEPOSIT");
        System.out.println("2. WITHDRAW");
        System.out.println("3. CHECK BALANCE");
        System.out.println("4. TRANSACTION HISTORY");
        System.out.println("5. CHANGE PIN");
        System.out.println("6. EXIT");

        System.out.print("ENTER CHOICE");
    }

    // deposit
    public static double Deposit(Scanner input, double balance ) {
        double deposit = 0;

        while (true) {
            System.out.print("ENTER DEPOSIT: ");
            deposit = input.nextDouble();
            if (deposit > 0) {
                System.out.println("SUCCESFULL DEPOSIT");
                balance += deposit;
                System.out.println("UPDATED BALANCE: " + balance);

                break;
            }

            System.out.println("INVALID");
        }

        return balance;

    }

    // withdraw

    public static double withdraw(Scanner input, double balance) {
        double withdraw = 0;

        while (true) {
            System.out.print("ENTER AMOUNT: ");
            withdraw = input.nextDouble();
            if (withdraw > 0 && withdraw <= balance) {
                balance -= withdraw;
                System.out.println("SUCCESSFULLY WITHDRAW" + withdraw);
                System.out.println("UPDATED BALANCE: " + balance);
                break;
            }

            System.out.println("INVALID AMOUNT");
        }

        return balance;
    }

    public static void Transaction_History(String[] transactionName, double[] transactionAmount, int transactionSize) {
        for(int i = 0 ; i < transactionSize; i++) {
            System.out.println((i + 1) + transactionName[i] + transactionAmount[i]);
        }
    } 

    // i add this so the new pin will matter 

    public static boolean ConfirmPin(Scanner input, int PIN) {
        int ConfirmPin = 0;

        System.out.print("ENTER YOUR PIN: ");
        ConfirmPin = input.nextInt();
        if(ConfirmPin != PIN) {
            return false;
        } else {
            return true;
            
        }
    }

    public static int changePIn(Scanner input, int PIN) {
        int ChangePIN = 0;
        while(true) {
            System.out.println("ENTER NEW PIN: ");
            ChangePIN = input.nextInt();
            if(ChangePIN > 1000 & ChangePIN < 9999) {
                System.out.println("PIN HAS BEEN CHANGED TO " + ChangePIN);
                break;
            }
            System.out.println("INVALID PIN");
        }

        return ChangePIN;
    }


    

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int PIN = setupPin(input);
        double balance = setUpBalance(input);

        double originalBalance = balance;
        // in this part i put this transaction size so my array will look like a dynamic 
        int transactionSize = 0;
        String[] transactionName = new String[100];

        double[] transactionAmount = new double[100];

        // validation
        approve(PIN, balance);

        int choice = 0;

        do {
            menu();
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    if(ConfirmPin(input, PIN) == true) {
                    originalBalance = balance;
                    balance = Deposit(input, balance);
                    transactionAmount[transactionSize] = balance - originalBalance;
                    transactionName[transactionSize] = " DEPOSIT += ";
                    transactionSize++;
                    } else {
                        System.out.println("WRONG PIN");
                        break;
                    }

                    break;
                case 2:
                    if(ConfirmPin(input, PIN)) {
                    originalBalance = balance;
                    balance = withdraw(input, balance);
                    transactionAmount[transactionSize] = originalBalance - balance;
                    transactionName[transactionSize] = " WITHDRAW -= ";
                    transactionSize++;
                    } else {
                        System.out.println("WRONG PIN");
                        break;
                    }
                    break;

                case 3:
                    System.out.println("BALANCE: " + balance);
                    break;

                case 4:
                    if(transactionSize == 0) {
                        System.out.println("NO TRANSACTION HISTORY");
                    } else {
                    Transaction_History(transactionName, transactionAmount, transactionSize);
                    }

                    break;


                case 5:
                    
                    if(ConfirmPin(input, PIN) == true) {
                        PIN = changePIn(input, PIN);
                    } else {
                        System.out.println("WRONG PIN");
                        break;
                    }
                    
                    break;

                case 6:

                    System.out.println("EXiTTING PROGRAM");

                    break;

                default:

                    System.out.println("INVALID INPUT");
                    break;
            }

        } while (choice != 6);

        input.close();
    }
}