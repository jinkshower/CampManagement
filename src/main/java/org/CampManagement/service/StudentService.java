package org.CampManagement.service;

import org.CampManagement.model.Student;
import org.CampManagement.store.StudentStore;

import java.util.List;

public class StudentService {

    public static StudentStore studentStore = new StudentStore();

    public boolean validateId(int studentId) {
        return studentStore.validateId(studentId);
    }

    public String getStudentName(int studentId) {
        return studentStore.getStudentName(studentId);
    }

    public void printStudentNamesAndIds() {
        List<Student> students = studentStore.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("수강생 목록이 비어있습니다.");
            return;
        }

        for (Student student : students) {
            System.out.println("이름: " + student.getName() + ", 학생 ID: " + student.getStudentId());
        }
    }

    private int nextStudentId = 0;

    public int generateStudentId () {
        return ++nextStudentId;
    }

    public void saveStudent (String name, int studentId){
        studentStore.saveStudent(studentId, name);
    }
}
