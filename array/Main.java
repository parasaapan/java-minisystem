package array;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] grades = { 85, 92, 78, 95, 88, 76, 90 };
        int[] attendance = new int[7];
        int[] sorted_grades = Arrays.copyOf(grades, grades.length);
        int choice = 0;
        do {

            System.out.println("1. DISPLAY GRADE ");
            System.out.println("2. SORT GRADE");
            System.out.println("3. ATTENDANCE");
            System.out.println("4. COMPARE");
            System.out.println("5.Highest grades");
            System.out.println("6. Lowest grade");
            System.out.println("7. Remove Grade");
            System.out.print("ENTER CHOICE: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(Arrays.toString(grades));
                    break;
                case 2:

                    Arrays.sort(sorted_grades);
                    System.out.println(Arrays.toString(sorted_grades));
                    break;
                case 3:
                    Arrays.fill(attendance, 100);
                    System.out.println(Arrays.toString(attendance));
                    break;
                case 4:
                    System.out.println(Arrays.compare(grades, sorted_grades));
                    break;
                case 5:
                    Arrays.sort(sorted_grades);
                    int highest = sorted_grades[sorted_grades.length - 1];
                    System.out.println("HIGIHEST: " + highest);
                    break;
                case 6: 
                    Arrays.sort(sorted_grades);
                    int lowest = sorted_grades[sorted_grades.length - sorted_grades.length];
                    System.out.println("LOWEST: " + lowest);

                    break;
                case 7:
                    // Ask the user for the grade they want to delete from the array.
                    int number_TO_REMOVE = 0;
                    System.out.println(Arrays.toString(grades));
                    System.out.print("ENTER NUMBER TO REMOVE: ");
                    number_TO_REMOVE = input.nextInt();

                    // Track whether the target value exists in the array.
                    boolean isfound = false;
                    int target_index = -1;

                    // Search for the first matching grade in the current array.
                    for (int i = 0; i < grades.length; i++) {
                        if (number_TO_REMOVE == grades[i]) {
                            isfound = true;
                            target_index = i;
                            break; // Stop after finding the first match.
                        }
                    }

                    // If the grade was not found, inform the user and exit the case.
                    if (!isfound) {
                        System.out.println("NOT FOUND");
                        break;
                    }

                    // Create a new array one slot shorter than the original.
                    int[] copy_of_grade = new int[grades.length - 1];

                    // Copy all values before the target index into the new array.
                    for (int i = 0; i < target_index; i++) {
                        copy_of_grade[i] = grades[i];
                    }

                    // Copy all values after the target index, shifting them left by one.
                    for (int i = target_index + 1; i < grades.length; i++) {
                        copy_of_grade[i - 1] = grades[i];
                    }

                    // Replace the old array with the updated one to remove the selected grade.
                    grades = copy_of_grade;
                    System.out.println("UPDATED GRADES: " + Arrays.toString(grades));
                    break;
                default:

                    break;
            }
        } while (choice != 9);

        input.close();
    }

}