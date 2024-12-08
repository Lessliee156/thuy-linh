/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentManagerApp;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Admin
 */
public class StudentManager {
     public static void main(String[] args) {
        MyStack myStack = new MyStack();
        Scanner scanner = new Scanner(System.in);

        // Main menu loop
        while (true) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Sort Students by Marks");
            System.out.println("6. Search for Student by ID");
            System.out.println("7. Pop Last Deleted Student");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Add Student
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student marks: ");
                    double marks = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline


            myStack.addStudent(new Student(id, name, marks));
                    break;

                case 2:
                    // Edit Student
                    System.out.print("Enter student ID to edit: ");
                    int editId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new marks: ");
                    double newMarks = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline

                    myStack.editStudent(editId, newName, newMarks);
                    break;

                case 3:
                    // Delete Student
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    myStack.deleteStudent(deleteId);
                    break;

                case 4:
                    // Display All Students
                    myStack.displayStudents();
                    break;

                case 5:
                    // Sort Students by Marks
                    myStack.sortStudents();
                    myStack.displayStudents();
                    break;

                case 6:
                    // Search for Student by ID
                    System.out.print("Enter student ID to search: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    Student foundStudent = myStack.searchStudent(searchId);
                    if (foundStudent != null) {
                        System.out.println("Found Student: " + foundStudent);
                    }
                    break;

                case 7:
                    // Pop Last Deleted Student
                    Student poppedStudent = myStack.popDeletedStudent();
                    if (poppedStudent != null) {
                        System.out.println("Popped Deleted Student: " + poppedStudent);
                    }
                    break;

                case 8:
                    // Exit
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
