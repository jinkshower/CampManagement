package org.CampManagement.store;

import org.CampManagement.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentStore {
    private List<Student> list = new ArrayList<>();

    public void addStudent(Student student) {
        list.add(student);
    }

    public List<String> getStudentListWithIds() {
        List<String> studentListWithIds = new ArrayList<>();
        for (Student student : list) {
            String studentInfo = "이름: " + student.getName() + ", ID: " + student.getStudentId();
            studentListWithIds.add(studentInfo);
        }
        return studentListWithIds;
    }

    public void printStudentListWithIds() {
        List<String> studentListWithIds = getStudentListWithIds();
        if (studentListWithIds.isEmpty()) {
            System.out.println("수강생 목록이 비어 있습니다.");
        } else {
            System.out.println("수강생 목록:");
            for (String studentInfo : studentListWithIds) {
                System.out.println(studentInfo);
            }
        }
    }

    public Student findStudentById(int studentId) {
        for (Student student : list) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null; // 해당 ID를 가진 학생이 없을 경우 null 반환
    }

    public boolean validateId(int studentId) {
        return list.stream().anyMatch(s -> studentId == (s.getStudentId()));
    }

}
