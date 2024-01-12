package org.CampManagement.service;

import org.CampManagement.store.StudentStore;

public class StudentService {
    private StudentStore studentStore = new StudentStore();

    public boolean validateId(int studentId) {
        return studentStore.validateId(studentId);
    }
}
