package org.CampManagement.store;

import org.CampManagement.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentStore {
    private List<Student> list = new ArrayList<>();

    public boolean validateId(int studentId) {
        return list.stream().anyMatch(s -> studentId == (s.getStudentId()));
    }

}
