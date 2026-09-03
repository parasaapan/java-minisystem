package FUNDAMENTALSOOP;
    class Student {
        private String name;
        private int age;

        Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
public class referencevariable_objectmemory {
    public static void main(String[] args) {

        Student s1 = new Student("Arrel", 19);
        // s1 is the reference variable that refers to the object or pointing to the object
        // new Student() create the actual object

        // MULTIPLE REFERENCE CAN POINT TO ONE OBEJCT
        // ex:
        Student s2 = s1; // s2 now share the same memory address of s1
        
        // so when you compare them using == the answer is true.
        if(s2 == s1) {
            System.out.println("True");
        }

      
    }
}
