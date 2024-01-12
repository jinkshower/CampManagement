package org.CampManagement;

import org.CampManagement.model.Student;
import org.CampManagement.service.ScoreService;
import org.CampManagement.service.StudentService;
import org.CampManagement.service.SubjectService;
import org.CampManagement.store.StudentStore;

public class ManagementApp {

    private static StudentService studentService;
    private SubjectService subjectService;
    private ScoreService scoreService;

    public static void main(String[] args) {
        StudentStore studentStore = new StudentStore();
        studentService = new StudentService(studentStore);

    }

    public ManagementApp() {



        studentService.addStudent(new Student(1, "John Doe"));
        studentService.addStudent(new Student(2, "Jane Doe"));
    }

    private void printStudentList() {
        System.out.println("Printing Student List:");
        studentService.printStudentListWithIds();
    }

    private void printStudentNamesWithIds() {
        System.out.println("\nPrinting Student Names with IDs:");
        for (String studentInfo : studentService.getStudentListWithIds()) {
            System.out.println(studentInfo);
        }
    }
}
