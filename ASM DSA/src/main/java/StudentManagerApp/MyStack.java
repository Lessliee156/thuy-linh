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
public class MyStack {
   private Stack<Student> students = new Stack<>();          // Stack to hold active students
    private Stack<Student> deletedStudents = new Stack<>();   // Stack to hold deleted students

    // Add a new student
    public void addStudent(Student student) {
        students.push(student);
        System.out.println("Added student: " + student);
    }

    // Edit an existing student by ID
    public boolean editStudent(int id, String newName, double newMarks) {
        for (Student student : students) {
            if (student.id == id) {
                student.name = newName;
                student.marks = newMarks;
                System.out.println("Updated student with ID: " + id);
                return true;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
        return false;
    }

    // Delete a student by ID
    public boolean deleteStudent(int id) {
        for (Student student : students) {
            if (student.id == id) {
                deletedStudents.push(student);  // Save to deleted stack
                students.remove(student);       // Remove from main stack
                System.out.println("Deleted student with ID: " + id);
                return true;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
        return false;
    }

    // Pop the last deleted student
    public Student popDeletedStudent() {
        if (deletedStudents.isEmpty()) {
            System.out.println("No deleted students to pop.");
            return null;
        }
        return deletedStudents.pop();
    }

    // Display all students in the main stack
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the stack.");
        } else {
            System.out.println("Students in Stack:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // Sort students by marks
    public void sortStudents() {
        students.sort((s1, s2) -> Double.compare(s1.marks, s2.marks));
        System.out.println("Students sorted by marks.");
    }

    // Search for a student by ID
    public Student searchStudent(int id) {
         // Sort the students list by ID if it's not sorted
    students.sort(Comparator.comparingInt(student -> student.id));
    
    int left = 0;
    int right = students.size() - 1;
    
    while (left <= right) {
        int mid = left + (right - left) / 2;  // Prevent overflow
        Student midStudent = students.get(mid);

        // If the student ID matches
        if (midStudent.id == id) {
            return midStudent;
        }

        // If the ID is smaller, search in the left half
        if (midStudent.id > id) {
            right = mid - 1;
        } 
        // If the ID is larger, search in the right half
        else {
            left = mid + 1;
        }
    }
    
    // If the student was not found
    System.out.println("Student with ID " + id + " not found.");
    return null;
    }

   

}
