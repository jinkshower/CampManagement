package org.CampManagement.store;

import org.CampManagement.model.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectStore {
    private List<Subject> list = new ArrayList<>();

<<<<<<< HEAD
    public void addSubject(Subject subject) {
        list.add(subject);
    }

    public List<Subject> getSubjects() {
        return list;
    }
=======
    public String getType(int studentId, int subjectId) {

        Subject subject = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStudentId() == studentId && list.get(i).getSubjectId() == subjectId) {
                subject = list.get(i);
            }
        }

        return subject.getSubjectType();
    }

>>>>>>> 0b3ee309929728f6f3a8212b496c00cc1723727c
}
