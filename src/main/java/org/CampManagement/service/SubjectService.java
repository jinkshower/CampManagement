package org.CampManagement.service;

import java.util.List;
import java.util.Optional;
import org.CampManagement.model.Subject;
import org.CampManagement.store.SubjectStore;

public class SubjectService {
    private SubjectStore subjectStore;

    public boolean validateSubjectId(int subjectId) {
        return subjectStore.validateSubjectId(subjectId);
    }
}
