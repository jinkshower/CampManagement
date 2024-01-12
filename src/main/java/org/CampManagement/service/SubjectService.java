package org.CampManagement.service;

import java.util.List;
import java.util.Optional;
import org.CampManagement.model.Subject;
import org.CampManagement.store.SubjectStore;

public class SubjectService {
    private SubjectStore subjectStore;

    public SubjectService(SubjectStore subjectStore) {
        this.subjectStore = subjectStore;
    }

    // 수강생 특정 과목 회차별 등급 조회 기능 추가
    public void getGradesByIdAndSubject(int studentId, String subjectName) {
        List<Subject> subjects = subjectStore.getSubjects();
        Optional<Subject> matchingSubject = subjects.stream()
                .filter(s -> s.getStudentId() == studentId && s.getSubjectName().equals(subjectName))
                .findFirst();

        if (matchingSubject.isPresent()) {
            Subject subject = matchingSubject.get();
            System.out.println("회차별 등급 조회 결과:");
            for (int i = 0; i < subject.getGrades().size(); i++) {
                System.out.println("회차 " + (i + 1) + ": " + subject.getGrades().get(i));
            }
        } else {
            System.out.println("해당 수강생 또는 과목이 존재하지 않습니다.");
        }
    }
}
