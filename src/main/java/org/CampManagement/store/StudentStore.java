package org.CampManagement.store;

import org.CampManagement.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class StudentStore {
    private static Map<Integer, String> studentMap = new HashMap<>();

    public static void saveStudent(int studentId, String name) {
        studentMap.put(studentId, name);
        System.out.println("Student saved - StudentId: " + studentId + ", Name: " + name);
    }
}

