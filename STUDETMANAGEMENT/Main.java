package STUDETMANAGEMENT;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int menu(Scanner input, int choice) {

        System.out.println("===== STUDENT MANAGEMENT =====");
        System.out.println("1. ADD STUDENT.");
        System.out.println("2. View ALL STUDENT.");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Sort Students");
        System.out.println("7. Exit");
        System.out.print("ENTER CHOICE: ");
        choice = input.nextInt();

        return choice;
    }

    public static boolean CheckStudent(int studentcount) {
        if (studentcount == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int Add_Student(Scanner input, String[] StudentId, String[] Name, int[] Age, String[] Program,
            int[] grade, int studentcount) {

        while (true) {
            boolean istrue = false;
            System.out.println("STUDENT ID: ");
            StudentId[studentcount] = input.next();

            for (int i = 0; i < studentcount; i++) {
                if (StudentId[studentcount].equals(StudentId[i])) {
                    istrue = true;
                    break;
                }

            }

            if (!istrue) {
                break;
            }

            System.out.println("STUDENT ID ALREADY EXISTING");
        }

        input.nextLine();

        while (true) {
            System.out.println("Name: ");
            Name[studentcount] = input.nextLine();
            if (Name[studentcount] != "") {
                break;
            }

            System.out.println("NAME CANNOT BE EMPTY");
        }

        while (true) {
            System.out.println("AGE: ");
            Age[studentcount] = input.nextInt();
            if (Age[studentcount] >= 15 && Age[studentcount] <= 100) {
                break;
            }
            System.out.println("INVALID AGE");
        }

        input.nextLine();

        while (true) {
            System.out.println("Program: ");
            Program[studentcount] = input.nextLine();
            if (Program[studentcount] != "") {
                break;
            }

            System.out.println("PROGRAM CANNOT BE EMPTY");
        }

        while (true) {
            System.out.println("GRADE: ");
            grade[studentcount] = input.nextInt();
            if (grade[studentcount] >= 0 && grade[studentcount] <= 100) {
                break;
            }
            System.out.println("INVALID GRADE!! (0-100) RANGE");
        }

        return studentcount + 1;

    }

    public static void View_Student(String[] StudentId, String[] Name, int[] Age, String[] Program,
            int[] grade, int studentcount) {
        System.out.println("========LIST OF ALL STUDENT=======");
        System.out.println();
        System.out.printf("%-10s %-15s %-8s %-7s %-8s%n", "ID", "NAME", "AGE", "PROGRAM", "GRADE");
        for (int i = 0; i < studentcount; i++) {
            System.out.printf("%-10s %-15s %-8d %-7s %-8d%n", StudentId[i], Name[i], Age[i], Program[i],
                    grade[i]);
        }
    }

    public static void Search_Student(String[] StudentId, String[] Name, int[] Age, String[] Program,
            int[] grade, int studentcount, Scanner input) {
        String id;

        System.out.println("ENTER ID: ");
        id = input.next();
        boolean isFound = false;
        for (int i = 0; i < studentcount; i++) {
            if (id.equals(StudentId[i])) {
                System.out.println("Name: " + Name[i]);
                System.out.println("AGE: " + Age[i]);
                System.out.println("PROGRAM: " + Program[i]);
                System.out.println("GRADE: " + grade[i]);
                isFound = false;
                break;
            }
        }
        if (!isFound) {
            System.out.println("STUDENT NOT FOUND");
        }
    }

    public static void Update_Student(String[] StudentId, String[] Name, int[] Age, String[] Program,
            int[] grade, int studentcount, Scanner input) {

        String id;

        System.out.println("ENTER ID: ");
        id = input.next();
        boolean isFound = false;
        int index = 0;

        for (int i = 0; i < studentcount; i++) {
            if (id.equals(StudentId[i])) {
                System.out.println("Name: " + Name[i]);
                System.out.println("AGE: " + Age[i]);
                System.out.println("PROGRAM: " + Program[i]);
                System.out.println("GRADE: " + grade[i]);
                index = i;
                isFound = true;
                break;
            }
        }

        if (isFound) {
            while (true) {
                boolean istrue = false;
                System.out.println("STUDENT NEW ID: ");
                String newId = input.next();

                for (int i = 0; i < studentcount; i++) {
                    if (newId.equals(StudentId[i])) {
                        istrue = true;
                        break;
                    }

                }

                if (!istrue) {
                    StudentId[index] = newId;
                    break;
                }

                System.out.println("STUDENT ID ALREADY EXISTING");
            }

            input.nextLine();

            while (true) {
                System.out.println("NEW Name: ");
                Name[index] = input.nextLine();
                if (Name[index] != "") {
                    break;
                }

                System.out.println("NAME CANNOT BE EMPTY");
            }

            while (true) {
                System.out.println("NEW AGE: ");
                Age[index] = input.nextInt();
                if (Age[index] >= 15 && Age[index] <= 100) {
                    break;
                }
                System.out.println("INVALID AGE");
            }

            input.nextLine();

            while (true) {
                System.out.println("New Program: ");
                Program[index] = input.nextLine();
                if (Program[index] != "") {
                    break;
                }

                System.out.println("PROGRAM CANNOT BE EMPTY");
            }

            while (true) {
                System.out.println("NEW GRADE: ");
                grade[index] = input.nextInt();
                if (grade[index] >= 0 && grade[index] <= 100) {
                    break;
                }
                System.out.println("INVALID GRADE!! (0-100) RANGE");
            }
        }
    }

    public static int Remove_Student(String[] StudentId, String[] Name, int[] Age, String[] Program,
            int[] grade, int studentcount, Scanner input) {

        int studentRemove = studentcount;
        String id;
        boolean isfound = false;
        int index = 0;

        System.out.print("ENTER ID TO REMOVE: ");
        id = input.next();
        for (int i = 0; i < studentcount; i++) {
            if (id.equals(StudentId[i])) {
                isfound = true;
                index = i;
            }
        }
        if (!isfound) {
            System.out.println("STUDENT NOT FOUND");

        } else {

            for (int i = index; i < studentcount - 1; i++) {
                StudentId[i] = StudentId[i + 1];
                Name[i] = Name[i + 1];
                Age[i] = Age[i + 1];
                Program[i] = Program[i + 1];
                grade[i] = grade[i + 1];
            }

            studentRemove--;
            System.out.println("STUDENT HAS BEEN REMOVE");
        }

        return studentRemove;
    }

    public static int Sortmenu(int choicemenu,Scanner input) {

        System.out.println("==== SORT ====");
        System.out.println();
        System.out.println("1. Grade");
        System.out.println("2. Name ");
        System.out.print("ENTER CHOICE: ");
        choicemenu = input.nextInt();

        return choicemenu;
    }

    public static void SortGrade(int[] grade, int studentcount) {

        int[] copy_of_Grades = new int[studentcount];
        for(int i = 0; i < studentcount; i++) {
            copy_of_Grades[i] = grade[i];
        }
        Arrays.sort(copy_of_Grades);
        System.out.println(Arrays.toString(copy_of_Grades));
    }

    

    

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        int studentcount = 0;
        int choicemenu = 0;

        String[] StudentId = new String[100];
        String[] Name = new String[100];
        int[] Age = new int[100];
        String[] Program = new String[100];
        int[] grade = new int[100];

        do {
            choice = menu(input, choice);
            switch (choice) {
                case 1:
                    studentcount = Add_Student(input, StudentId, Name, Age, Program, grade, studentcount);

                    break;
                case 2:
                    if (CheckStudent(studentcount)) {
                        System.out.println("NO STUDENT ADD FIRST. ");
                        break;
                    }

                    View_Student(StudentId, Name, Age, Program, grade, studentcount);

                    break;

                case 3:
                    if (CheckStudent(studentcount)) {
                        System.out.println("NO STUDENT ADD FIRST");
                        break;
                    }

                    Search_Student(StudentId, Name, Age, Program, grade, studentcount, input);

                    break;

                case 4:

                    if (CheckStudent(studentcount)) {
                        System.out.println("NO STUDENT ADD FIRST");
                        break;
                    }

                    Update_Student(StudentId, Name, Age, Program, grade, studentcount, input);

                    break;

                case 5:
                    if (CheckStudent(studentcount)) {
                        System.out.println("NO STUDENT ADD FIRST");
                        break;
                    }
                    View_Student(StudentId, Name, Age, Program, grade, studentcount);
                    studentcount = Remove_Student(StudentId, Name, Age, Program, grade, studentcount, input);

                    break;

                case 6:

                    if(CheckStudent(studentcount)) {
                        System.out.println("NO STUDENT ADD FIRST");
                        break;
                    }

                    choicemenu = Sortmenu(choicemenu, input);
                    if(choicemenu == 1) {
                         
                    } else if (choicemenu == 2) {

                    } else {
                        System.out.println("INVALID INPUUT");
                    }
 

                    break;

                case 7:
                    System.out.println("PROGRAM EXIT");
                    break;

                default:

                    System.out.println("INVALID INPUT");
                    break;
            }
        } while (choice != 7);

    }
}