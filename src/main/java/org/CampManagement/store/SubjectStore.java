package org.CampManagement.store;

import org.CampManagement.model.Subject;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class SubjectStore {

    public static List<Subject> subjects = new ArrayList<>();

    public String getType(int studentId, int subjectId) {

        Subject subject = null;
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).getStudentId() == studentId && subjects.get(i).getSubjectId() == subjectId) {
                subject = subjects.get(i);
            }
        }

        return subject.getSubjectType();
    }

    public static void saveSubject(int subjectId, int studentId, String subjectType, String subjectName) {
        Subject newSubject = new Subject(subjectId, studentId, subjectType, subjectName);
        subjects.add(newSubject);
        System.out.println("Subject saved - StudentId: " + studentId + ", SubjectId" + subjectId + ", Name: " + subjectType + ", Subject: " + subjectName);
    }

    public static Subject getSubjectByIdAndName(int studentId, String subjectName) {
        return subjects.stream()
                .filter(subject -> subject.getStudentId() == studentId
                        && subject.getSubjectName().equals(subjectName))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    // 점수 수정 : 없는과목 예외
    public boolean validateSubjectByStudentId(int studentId, int subjectId) {
        return subjects.stream()
                .anyMatch(subject -> subject.getStudentId() == studentId
                        && subject.getSubjectId() == subjectId);
    }

    public String getSubjectsById(int studentId) {
        return subjects.stream()
                .filter(subject -> subject.getStudentId() == studentId)
                .map(subject -> subject.getSubjectName())
                .collect(Collectors.joining(","));
    }
}
