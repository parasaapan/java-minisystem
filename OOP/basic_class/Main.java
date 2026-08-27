package OOP.basic_class;
import java.util.Scanner;

class Student {

    String name;
    int age;
    String course;
    double grade;

}

public class Main {
    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);

    // i learn that these are reference variable and not the object itself. Its the reference where the objectitself
    Student s1 = new Student();
    Student s2 = new Student();
    
    
    s1.name = "Arrel";
    s1.age = 18;
    s1.course = "Java";
    s1.grade = 99;

    s2.name = "Jacob";
    s2.age = 19;
    s2.course = "BSIT";
    s2.grade = 99;


    System.out.println("=======STUDENT 1========");
    System.out.println("NAME " + s1.name);
    System.out.println("AGE " + s1.age);
    System.out.println("COURSE " + s1.course);
    System.out.println("GRADE " + s1.grade);
    
     System.out.println("=======STUDENT 2========");
    System.out.println("NAME " + s2.name);
    System.out.println("AGE " + s2.age);
    System.out.println("COURSE " + s2.course);
    System.out.println("GRADE " + s2.grade);


    Student[] students = new Student[2];

        for(int i = 0 ; i < 2; i++) {
            students[i] = new Student(); // why this? 
            // you need to point each index to the object

            System.out.println("STUDENT " + (i + 3));
            System.out.print("Name: ");
            students[i].name = input.next();
            System.out.print("AGE: ");
            students[i].age = input.nextInt();
            System.out.print("COURSE: ");
            students[i].course = input.next();
            System.out.print("GRADE: ");
            students[i].grade = input.nextDouble();
        }

        for(Student std : students) {
            System.out.println("Name " + std.name);
            System.out.println("AGe " + std.age);
            System.out.println("COURSE " + std.course);
            System.out.println("GRADE " + std.grade);
        }


        input.close();
    }
}
