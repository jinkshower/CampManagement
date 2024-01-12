package org.CampManagement.service;

import org.CampManagement.model.Student;
import org.CampManagement.store.StudentStore;

import java.util.List;

public class StudentService {

    private final StudentStore studentStore;

    public StudentService(StudentStore studentStore) {
        this.studentStore = studentStore;
    }

    public void addStudent(Student student) {
        studentStore.addStudent(student);
    }

    public List<String> getStudentListWithIds() {
        return studentStore.getStudentListWithIds();
    }

    public void printStudentListWithIds() {
        studentStore.printStudentListWithIds();
    }

    public Student findStudentById(int studentId) {
        return studentStore.findStudentById(studentId);
    }

    public boolean validateId(int studentId) {
        return studentStore.validateId(studentId);
    }
}
