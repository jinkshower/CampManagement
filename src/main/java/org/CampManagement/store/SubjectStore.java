package org.CampManagement.store;

import org.CampManagement.model.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectStore {
    private List<Subject> list = new ArrayList<>();

    public void addSubject(Subject subject) {
        list.add(subject);
    }

    public List<Subject> getSubjects() {
        return list;
    }
}
