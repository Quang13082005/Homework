import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Add students to the list.");
            System.out.println("2. Show the entire list of students.");
            System.out.println("3. Delete students by name.");
            System.out.println("4. Search for students by name.");
            System.out.println("5. Edit student name.");
            System.out.println("0. exit program.");
            System.out.println("Enter your choice:  ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Add information student you want");
                    addStudent(studentList);
                    break;
                case 2:
                    System.out.println("Show all information student");
                    showInformation(studentList);
                    break;
                case 3:
                    deleteStudent(studentList);
                case 4:
                    searchInformation(studentList);
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again");
            }
        } while (choice != 0);
    }

    public static void addStudent(List<Student> studentList) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter student name: ");
        String name = sc.nextLine();

        System.out.println("Enter student address: ");
        String address = sc.nextLine();

        System.out.println("Enter student age: ");
        int age = sc.nextInt();
        sc.nextLine();

        Student student = new Student(name, age, address);
        studentList.add(student);
    }

    public static void showInformation(List<Student> studentList) {
        for (Student num : studentList) {
            System.out.println(num);
        }
    }

    public static void deleteStudent(List<Student> studentList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name student you want to delete: ");
        String name = sc.nextLine();
        boolean isDelete = false;
        for (Student num : studentList) {
            if (num.getName().equals(name)){
                isDelete=true;
                studentList.remove(num);
                System.out.println("Delete successfully "+num.getName());
                break;
            }
        } if (!isDelete){
            System.out.println("Don have "+ name +" on the list");
        }

    }
    public static void searchInformation(List<Student> studentList){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student name you want to search: ");
        String name = sc.nextLine();
        boolean isStudentFound=false;
        for (Student num: studentList){
            if (num.getName().equals(name)){
                isStudentFound=true;
                System.out.println(num);
                break;
            }
        } if (!isStudentFound){
            System.out.println("Don't have student "+name+" on the list ");
        }
    }
}