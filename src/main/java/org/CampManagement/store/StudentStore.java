package org.CampManagement.store;

import org.CampManagement.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class StudentStore {
    private List<Student> list = new ArrayList<>();

    public boolean validateId(int studentId) {
        return list.stream().anyMatch(s -> studentId == (s.getStudentId()));
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(list);
    }

    public void printStudentNamesAndIds() {
        if (list.isEmpty()) {
            System.out.println("수강생 목록이 비어있습니다.");
            return;
        }

        for (Student student : list) {
            System.out.println("이름: " + student.getName() + ", 학생 ID: " + student.getStudentId());
        }
    }

    public String getStudentName(int studentId) {
        for (Student student : list) {
            if (student.getStudentId() == studentId) {
                return student.getName();
            }
        }
        return null;
    }

    private static Map<Integer, String> studentMap = new HashMap<>();

    public static void saveStudent(int studentId, String name) {
        studentMap.put(studentId, name);
        System.out.println("Student saved - StudentId: " + studentId + ", Name: " + name);
    }

}

