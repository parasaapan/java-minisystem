
import java.util.Scanner;
import java.util.ArrayList;

public class Student {

    public static boolean NumberOfStudentInput(int numStudents, Scanner input) {
        if (numStudents < 1 || numStudents > 50) {
            return false;
        }

        return true;
    }

    public static void DataInputof_Students(Scanner input, ArrayList<String> studentName, int numStudents,
            ArrayList<Double> totalGradeEachStudent) {

        for (int i = 0; i < numStudents; i++) {
            String name = "";
            double total = 0;

            System.out.println("------------ STUDENT " + (i + 1) + "----------------");
            System.out.print("NAME: ");
            name = input.nextLine();

            for (int g = 0; g < 3; g++) {
                double gradestudent = 0;

                while (true) {
                    System.out.print("ENTER GRADE " + (g + 1) + ": ");
                    gradestudent = input.nextDouble();

                    if (gradestudent >= 0 && gradestudent <= 100) {
                        break;
                    }

                    System.out.println("INVALID INPUT! Try again.");

                }

                total += gradestudent;
            }

            input.nextLine();

            studentName.add(name);
            totalGradeEachStudent.add(total);

        }

    }

    public static void ComputeTheAverage(ArrayList<Double> average, ArrayList<Double> totalGradeEachStudent) {

        for (int i = 0; i < totalGradeEachStudent.size(); i++) {

            double averageEach = totalGradeEachStudent.get(i) / 3;

            average.add(averageEach);
        }

    }

    public static void Classification(ArrayList<Double> average, ArrayList<String> studentclassification) {

        for (int i = 0; i < average.size(); i++) {
            if (average.get(i) >= 90) {
                studentclassification.add("Excellent");
            } else if (average.get(i) >= 85) {
                studentclassification.add("Very Good");
            } else if (average.get(i) >= 75) {
                studentclassification.add("Passed");
            } else {
                studentclassification.add("Failed");
            }
        }
    }

    public static double ComputeClassAverage(ArrayList<Double> average) {
        double total = 0;

        for(int i = 0 ; i < average.size(); i++) {
            total += average.get(i);
        }


        return total / average.size();
    }

    public static int passed (ArrayList<Double> average) {

        int totalPassStudent = 0;

        for(int i = 0 ; i < average.size(); i++) {
            if(average.get(i) >= 75) {
                totalPassStudent++;
            }
        }

        return totalPassStudent;

    }

        public static int Failed (ArrayList<Double> average) {

        int totalFailesStudent = 0;

        for(int i = 0 ; i < average.size(); i++) {
            if(average.get(i) < 75) {
                totalFailesStudent++;
            }
        }

        return totalFailesStudent;

    }

    

    public static void FinalReport(ArrayList<String> studentName, ArrayList<Double> average,
            ArrayList<String> studentclassification, double classAverage, int a, int b) {
        
        double highestAverage = average.get(0);
        String highestAverageStudent = studentName.get(0);

        double lowestAverage = average.get(0);
        String lowestAverageStudent = studentName.get(0);

        for(int i = 0 ; i < average.size(); i++) {
            if(average.get(i) > highestAverage) {
                highestAverage = average.get(i);
                highestAverageStudent = studentName.get(i);
            }

            if(average.get(i) < lowestAverage) {
                lowestAverage = average.get(i);
                lowestAverageStudent = studentName.get(i);
            }
        }


        System.out.println();
        System.out.println();
        System.out.println("-----------FINAL REPORT-----------");
        System.out.printf("%-15s %-7s %-14s%n",
                "NAME", "AVERAGE", "CLASSIFICATION");

        for (int i = 0; i < studentName.size(); i++) {
            System.out.printf("%-15s %-7.2f %-14s%n",
                    studentName.get(i),
                    average.get(i),
                    studentclassification.get(i));
        }

        System.out.println();
        System.out.println();
        System.out.println("CLASS AVERAGE: " + classAverage);
        System.out.println("HIGHEST AVERAGE: " + highestAverage);
        System.out.println("NAME: " + highestAverageStudent);
        System.out.println("LOWEST AVERAGE: " + lowestAverage);
        System.out.println("NAME: " + lowestAverageStudent);
        System.out.println("NUMBER OF STUDENT PASSED: " + a);
        System.out.println("NUMBER OF STUDENT FAILED: " + b);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<String> studentName = new ArrayList<>();
        ArrayList<Double> average = new ArrayList<>();
        ArrayList<String> studentclassification = new ArrayList<>();

        ArrayList<Double> totalGradeEachStudent = new ArrayList<>();

        System.out.print("ENTER STUDENT NEED TO BE PROCESS: ");
        int numStudents = input.nextInt();
        input.nextLine();
        boolean validInput = NumberOfStudentInput(numStudents, input);


        if (validInput) {
            DataInputof_Students(input, studentName, numStudents, totalGradeEachStudent);
            ComputeTheAverage(average, totalGradeEachStudent);
            Classification(average, studentclassification);

            double classAverage = ComputeClassAverage(average);
            int passedStudents = passed(average);
            int failedStudents = Failed(average);  

            FinalReport(studentName, average, studentclassification, classAverage, passedStudents, failedStudents);
            
        } else {
            System.out.println("INVALID INPUT");
            System.out.println("PROGRAM EXIT");
            input.close();
        }

    }
}
