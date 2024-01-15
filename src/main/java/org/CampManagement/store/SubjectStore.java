package org.CampManagement.store;

import org.CampManagement.model.Subject;
import org.CampManagement.model.SubjectEnum;

import java.util.Map;
import java.util.HashMap;

public class SubjectStore {
    private static Map<Integer, Subject> subjectMap = new HashMap<>();

    public static void saveSubject(int subjectId, int studentId, SubjectEnum.SubjectType subjectType, SubjectEnum subjectName) {
        Subject newSubject = new Subject(subjectId, studentId, subjectType, subjectName);
        subjectMap.put(studentId, newSubject);
        System.out.println("Subject saved - StudentId: " + studentId + ", SubjectId" + subjectId + ", Name: " + subjectType + ", Subject: " + subjectName);
    }
}
