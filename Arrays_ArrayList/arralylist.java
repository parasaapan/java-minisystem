package Arrays_ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class arralylist {
    public static void main(String[] args) {

        ArrayList<Integer> diba = new ArrayList<>();
        ArrayList <Integer> dibaSorted = new ArrayList<>();
        dibaSorted.addAll(diba);
        Scanner input = new Scanner(System.in);
        int choice = 0;
        int grade;

        do {
            System.out.println("1 Add Grade");
            System.out.println("2. Remove Grade");
            System.out.println("3. PRINT ALL GRADE");
            System.out.println("4. SORT ALL GRADE");
            System.out.println("5. SORT GRADE REVERSE");
            System.out.println("6. HIGHEST GRADE");
            System.out.println("7. LOWEST GRADE");
            System.out.println("8. UPDATE GRADE");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("ENTER GRADE: ");
                    grade = input.nextInt();
                    diba.add(grade);
                    break;
                case 2:
                    if (diba.isEmpty()) {
                        System.out.println("ARRAY LIST IS EMPTY!!!!!!!!!!!! MAMAAAAAAAAA");
                        break;
                    }

                    System.out.println(diba);

                    System.out.println("ENTER GRADE TO REMOVE");
                    int gradetoRemove = input.nextInt();
                    boolean isfound = false;
                    for (int i = 0; i < diba.size(); i++) {
                        if (diba.get(i).equals(gradetoRemove)) {
                            isfound = true;
                            System.out.println("GRADE FOUND: " + diba.get(i));
                            diba.remove(i);
                            break;
                        }
                    }

                    if (!isfound) {
                        System.out.println("NO FOUND");
                    }
                    break;
                case 3:
                      for(int i = 0; i < diba.size(); i++) {
                        System.out.println("GRADES: " + diba.get(i));
                      }

                case 4:
                    if (diba.isEmpty()) {
                        System.out.println("ARRAY LIST IS EMPTY!!!!!!!!!!!! MAMAAAAAAAAA");
                        break;
                    }
                    dibaSorted.sort(Comparator.naturalOrder());
                    for(int print: dibaSorted) {
                        System.out.println(print);
                    }

                    break;

                case 5:
                     if (diba.isEmpty()) {
                        System.out.println("ARRAY LIST IS EMPTY!!!!!!!!!!!! MAMAAAAAAAAA");
                        break;
                    }
                    dibaSorted.sort(Comparator.reverseOrder());
                    for(int print: dibaSorted) {
                        System.out.println(print);
                    }
                    break;
                case 6:
                    dibaSorted.sort(Comparator.reverseOrder());
                    System.out.println("HIGHEST GRADE: " + dibaSorted.get(0));
                    break;

                case 7:
                    dibaSorted.sort(Comparator.naturalOrder());
                    System.out.println("LOWEST GRADE: " + dibaSorted.get(0));
                    break;
                case 8:
                     System.out.println("ENTER GRADE TO REMOVE");
                    int gradetoFind= input.nextInt();
                   boolean isfound_ = false;
                    for (int i = 0; i < diba.size(); i++) {
                        if (diba.get(i).equals(gradetoFind)) {
                            isfound = true;
                            System.out.println("GRADE FOUND: " + diba.get(i));
                            break;
                        }
                    }

                    if (!isfound_) {
                        System.out.println("NO FOUND");
                    }
                default:
                    break;
            }
        } while (choice != 9);


        input.close();
    }
}
