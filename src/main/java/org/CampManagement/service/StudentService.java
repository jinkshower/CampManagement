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

    private int nextStudentId = 0;

    public int generateStudentId () {
        return ++nextStudentId;
    }

    public void saveStudent (String name, int studentId){
        studentStore.saveStudent(studentId, name);
    }

    // 학생 이름 수정
    public Student updateStudent(int studentId, String updateName) {
        return StudentStore.updateStudent(studentId, updateName);
    }

    // 존재하는 학생 확인
    public boolean isValidStudentId(int StudentId) {
        return studentStore.isValidStudentId(StudentId);
    }
}
