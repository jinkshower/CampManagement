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

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public void printStudentNamesAndIds() {
        if (students.isEmpty()) {
            System.out.println("수강생 목록이 비어있습니다.");
            return;
        }

        for (Student student : students) {
            System.out.println("이름: " + student.getName() + ", 학생 ID: " + student.getStudentId());
        }
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

