/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentManagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class StudentManagement {
   private List<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addStudent() {
        try {
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Student Marks: ");
            double marks = scanner.nextDouble();

            students.add(new Student(id, name, marks));
            System.out.println("Student added successfully!");
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine(); // Clear input buffer
        }
    }

    public void editStudent() {
        try {
            System.out.print("Enter Student ID to edit: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            for (Student student : students) {
                if (student.getId() == id) {
                    System.out.print("Enter new name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter new marks: ");
                    double marks = scanner.nextDouble();

                    student.setName(name);
                    student.setMarks(marks);
                    System.out.println("Student updated successfully!");
                    return;
                }
            }
            System.out.println("Student with ID " + id + " not found.");
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine();
        }
    }

    public void deleteStudent() {
        try {
            System.out.print("Enter Student ID to delete: ");
            int id = scanner.nextInt();

            students.removeIf(student -> student.getId() == id);
            System.out.println("Student deleted successfully!");
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine();
        }
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void bubbleSort() {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).getMarks() > students.get(j + 1).getMarks()) {
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
        System.out.println("Students sorted by marks using Bubble Sort.");
        displayStudents();
    }

    public void selectionSort() {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (students.get(j).getMarks() < students.get(minIdx).getMarks()) {
                    minIdx = j;
                }
            }
            Student temp = students.get(minIdx);
            students.set(minIdx, students.get(i));
            students.set(i, temp);
        }
        System.out.println("Students sorted by marks using Selection Sort.");
        displayStudents();
    }

    public void searchStudent() {
        try {
            System.out.print("Enter Student ID to search: ");
            int id = scanner.nextInt();

            for (Student student : students) {
                if (student.getId() == id) {
                    System.out.println(student);
                    return;
                }
            }
            System.out.println("Student with ID " + id + " not found.");
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine();
        }
    }

    public void menu() {
        while (true) {
            System.out.println("\n--- Student Manager Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display Students");
            System.out.println("5. Sort Students (Bubble Sort)");
            System.out.println("6. Sort Students (Selection Sort)");
            System.out.println("7. Search Student by ID");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            
            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> addStudent();
                    case 2 -> editStudent();
                    case 3 -> deleteStudent();
                    case 4 -> displayStudents();
                    case 5 -> bubbleSort();
                    case 6 -> selectionSort();
                    case 7 -> searchStudent();
                    case 8 -> {
                        System.out.println("Exiting program.");
                        return;
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 8.");
                scanner.nextLine(); // Clear input buffer
            }
        }
    }

    public static void main(String[] args) {
        StudentManagement manager = new StudentManagement();
        manager.menu();
    }
}
