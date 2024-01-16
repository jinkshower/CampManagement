package org.CampManagement.store;

import org.CampManagement.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    // 학생 이름 수정
    public static Student updateStudent(int studentId, String updateName) {

        Student updateStudent = students.stream()
                .filter(s -> s.getStudentId() == studentId)
                .findFirst().orElse(null);

        updateStudent.updateName(updateName);

        return updateStudent;
    }

    // 존재하는 학생 확인
    public boolean isValidStudentId(int studentId) {
       return students.stream()
                .anyMatch(s -> s.getStudentId() == studentId);
    }
}

