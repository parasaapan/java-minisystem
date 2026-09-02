package OOP.constructor;
import java.util.Scanner;

class Student {
    String name;
    int age;
    double grade;



    Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public  void printInfo() {
        System.out.println("Name " + name);
        System.out.println("Age " + age);
        System.out.println("Grade " + grade);
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String name = "";
        int age = 0;
        double grade = 0;

        Student s1 = new Student(name,age,grade);

        System.out.println("ENTER NAME: ");
        name = input.next();
        System.out.println("ENTER AGE: ");
        age = input.nextInt();
        System.out.println("ENTER GRADE: ");
        grade = input.nextDouble();
        
        s1.printInfo( );

        input.close();
        
        
        
    }
}
