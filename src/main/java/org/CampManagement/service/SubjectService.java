package org.CampManagement.service;

import org.CampManagement.model.SubjectEnum;
import org.CampManagement.store.SubjectStore;

public class SubjectService {

    private static SubjectStore subjectStore = new SubjectStore();

    // 입력받은 subject가 SubjectEnum에 존재하는지 확인하는 메서드
    public static boolean isValidSubject (String subject){
        for (SubjectEnum subjectEnum : SubjectEnum.values()) {
            if (subjectEnum.name().equalsIgnoreCase(subject)) {
                return true;
            }
        }
        return false;
    }

    // 필수과목이 3개 미만이면 예외 처리
    public static void validateMandatorySubjects (String[]subjects) throws Exception {
        int mandatoryCount = 0;
        for (String subject : subjects) {
            if (SubjectService.isValidSubject(subject.trim())) {
                SubjectEnum subjectEnum = SubjectEnum.valueOf(subject.trim().toUpperCase());
                if ("필수".equals(subjectEnum.getSubjectType())) {
                    mandatoryCount++;
                }
            }
        }

        if (mandatoryCount < 3) {
            throw new Exception("필수과목은 3개 이상 선택해야 합니다.");
        }
    }

    // 선택과목이 2개 미만이면 예외 처리
    public static void validateSelectiveSubjects (String[]subjects) throws Exception {
        int selectiveCount = 0;
        for (String subject : subjects) {
            if (SubjectService.isValidSubject(subject.trim())) {
                SubjectEnum subjectEnum = SubjectEnum.valueOf(subject.trim().toUpperCase());
                if ("선택".equals(subjectEnum.getSubjectType())) {
                    selectiveCount++;
                }
            }
        }

        if (selectiveCount < 2) {
            throw new Exception("선택과목은 2개 이상 선택해야 합니다.");
        }
    }

    // 점수 수정 : 없는과목 예외
    public static boolean validateSubjectByStudentId(int studentId, int subjectId) {
        return  subjectStore.validateSubjectByStudentId(studentId, subjectId);
    }

    public String StudentSubjectName(int studentId) {
        return subjectStore.getSubjectsById(studentId);
    }
}
