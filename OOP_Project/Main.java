package OOP_Project;

class Student {

    private final int studentid;
    private String name;
    private int age;
    private String course;
    private String email;
    private double grade;
    private static int studentCount;

    private static final int PASSING_GRADE = 75;

    Student() {
        this(0, "Unknown", 0, "Undeclared", "Not provided", 0.0);
    }

    Student(int studentId, String name, int age) {
       this(studentId, name, age,"Undeclared", "Not provided", 0.0 );
    }

    Student(int studentId, String name, int age, String course, String email, double grade) {
        this.studentid = studentId;
        this.name = name;
        this.age = age;
        this.course = course;
        this.email = email;
        this.grade = grade;
        studentCount++;
    }

    int get_studentId() {
        return this.studentid;
    }

    String get_name() {
        return this.name;
    }

    int get_age() {
        return this.age;
    }

    String get_course() {
        return this.course;
    }

    String get_email() {
        return this.email;
    }

    double get_grade() {
        return this.grade;
    }

    public void setName(String name) {

        if (name.trim().isEmpty()) {
            System.out.println("Name should have name");
            return;
        }

        this.name = name;
    }

    public void setAge(int age) {
        if (age <= 0) {
            System.out.println("Age should be greater than 0");
            return;
        }

        this.age = age;
    }

    public void setCourse(String course) {

        if(course.trim().isEmpty()) {
            return;
        }

        this.course = course;
    }

    public void setEmail(String email) {
        if (email.trim().isEmpty()) {
            System.out.println("Email cannot be empty");
            return;
        }

        this.email = email;
    }

    public void setGrade(double grade) {
        if (grade < 0 || grade > 100) {
            System.out.println("Grade cannot be below 0 or greater than 100");
            return;
        }

        this.grade = grade;
    }

    // this are the methods or functions

    public void displayInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Course: " + this.course);
        System.out.println("Email: " + this.email);
        System.out.println("Grade: " + this.grade);
    }

    public void displayInfo(boolean showEmail) {
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Course: " + this.course);
        System.out.println("Grade: " + this.grade);

        if (showEmail) {
            System.out.println("Email: " + this.email);
        }
    }

    public boolean isPassed() {
        if(this.grade < PASSING_GRADE) {
            return false;
        } 
          
        return true;
        
    }

    public void updateGrade(double grade) {
        System.out.println("Current Grade: " + this.grade);

        setGrade(grade);

        System.out.println("UPDATED GRADE: " + this.grade);
        
    }

    public void updateProfile(String name, int age) {
        setName(name);
        setAge(age);
    }

    public void updateProfile(String name, int age, String course) {
        setName(name);
        setAge(age);
        setCourse(course);
    }


    public static int getStudentCount() {
        return studentCount;
    }


}

public class Main {

    public static void main(String[] args) {

    }

}
