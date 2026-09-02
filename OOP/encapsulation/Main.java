package OOP.encapsulation;

import java.util.Scanner;

class BankAccount {
    private String name;
    private double balance;
    private int pin;

    BankAccount(String name, double balance, int pin) {
        this.name = name;
        this.balance = balance;
        this.pin = pin;
    }

    public void Deposit(Scanner input) {
        double amount = 0;
        System.out.println("ENTER AMOUNT DEPOSIT: ");
        amount = input.nextDouble();
        if (amount <= 0) {
            System.out.println("ERROR");
        } else {
            this.balance += amount;
        }

    }

    public void Withdraw(Scanner input) {
        double amount = 0;
        boolean isvalid = true;
        System.out.println("ENTER AMOUNT: ");
        amount = input.nextDouble();

        if (amount <= 0) {
            isvalid = false;
            System.out.println("ERROR");
        } else if (amount > this.balance) {
            System.out.println("INSUFIECIENT BALANCE");
            isvalid = false;
        }

        if (isvalid) {
            this.balance -= amount;
        }

    }

    public boolean checkPin(Scanner input) {
        int tryPin = 0;
        System.out.println("ENTER PIN: ");
        tryPin = input.nextInt();
        if (tryPin == this.pin) {
            System.out.println("SUCCESS");
            return true;
        } else {

            System.out.println("ERROR PIN");
            return false;
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public void changePin(Scanner input) {
        int changePin = 0;
        int confirmPin = 0;
        System.out.println("ENTER NEW PIN: ");
        changePin = input.nextInt();
        System.out.println("CONFIRM NEW PIN");
        confirmPin = input.nextInt();

        if (changePin == confirmPin) {
            this.pin = confirmPin;
        } else {
            System.out.println("INVALID");
        }
    }

}

public class Main {

    public static int menuChoice(int choice, Scanner input) {
        System.out.println("1. DEPOSIT");
        System.out.println("2. WITHDRAW");
        System.out.println("3. CHECK BALANCE");
        System.out.println("4. Change PIN");
        System.out.println("5. Exit");
        System.out.print("ENter choice: ");
        choice = input.nextInt();

        return choice;

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int choice = 0;

        String name;
        double balance;
        int pin;

        System.out.print("ENTER ACCOUNT NAME: ");
        name = input.nextLine();
        System.out.print("ENTER INITIAL BALANCE: ");
        balance = input.nextDouble();
        System.out.print("SET PIN");
        pin = input.nextInt();

        BankAccount account1 = new BankAccount(name, balance, pin);

        do {

            choice = menuChoice(choice, input);
            switch (choice) {
                case 1:
                    account1.Deposit(input);
                    break;
                case 2:
                    account1.Withdraw(input);
                    break;

                case 3:
                    if (!account1.checkPin(input)) {
                        break;
                    }

                    account1.getBalance();
                    break;
                case 4:
                    if (!account1.checkPin(input)) {
                        break;
                    }

                    account1.changePin(input);

                    break;
                case 5:
                    System.out.println("EXIT");
                    break;
                default:
                    break;
            }
        } while (choice != 5);

        input.close();
    }
}
