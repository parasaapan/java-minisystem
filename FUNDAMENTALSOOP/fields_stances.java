package FUNDAMENTALSOOP;

class BankAccount{
    // this are field
    private String name;
    private int pin;
    private double balance;


    // this is a static belong to the class
    private static int totalAccounts = 2;

    BankAccount(String name, int pin, double balance) {
        this.balance = balance;
        this.name = name;
        this.pin = pin; 
    }
}

public class fields_stances {
    public static void main(String[] args) {
        // when you create new you making a instance of that field
        BankAccount account1 = new BankAccount("Arrel", 1234, 1000.00); 
        BankAccount account2 = new BankAccount("Jacob", 4321, 2000.00); 
    }

}
