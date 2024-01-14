package org.CampManagement.store;

import org.CampManagement.model.Subject;

import java.util.ArrayList;
import java.util.List;

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
}
