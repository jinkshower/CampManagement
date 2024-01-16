package org.CampManagement.store;

import org.CampManagement.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentStore {
    private static List<Student> students = new ArrayList<>();

    public boolean validateId(int studentId) {
        return students.stream()
                .map(Student::getStudentId)
                .anyMatch(id -> id == studentId);
    }

    public String getStudentName(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student.getName();
            }
        }
        return null;
    }

    public void saveStudent(int studentId, String name) {
        students.add(new Student(studentId, name));
        System.out.println("Student saved - StudentId: " + studentId + ", Name: " + name);
    }
}

