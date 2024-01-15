package org.CampManagement.store;

import org.CampManagement.model.Subject;
import org.CampManagement.model.SubjectEnum;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class SubjectStore {
    private List<Subject> list = new ArrayList<>();

    public String getType(int studentId, int subjectId) {

        Subject subject = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStudentId() == studentId && list.get(i).getSubjectId() == subjectId) {
                subject = list.get(i);
            }
        }

        return subject.getSubjectType();
    }

    private static Map<Integer, Subject> subjectMap = new HashMap<>();

    public static void saveSubject(int subjectId, int studentId, String subjectType, String subjectName) {
        Subject newSubject = new Subject(subjectId, studentId, subjectType, subjectName);
        subjectMap.put(studentId, newSubject);
        System.out.println("Subject saved - StudentId: " + studentId + ", SubjectId" + subjectId + ", Name: " + subjectType + ", Subject: " + subjectName);

    }
}
