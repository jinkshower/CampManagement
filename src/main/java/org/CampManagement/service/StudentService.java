package org.CampManagement.service;

import org.CampManagement.store.StudentStore;

public class StudentService {
    private static int nextStudentId = 1;

    public static int generateStudentId() {
        return nextStudentId++;
    }

    public static void saveStudent(String name) {
        int studentId = generateStudentId();
        StudentStore.saveStudent(studentId, name);
    }
}

