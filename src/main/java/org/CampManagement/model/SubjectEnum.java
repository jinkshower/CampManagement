package org.CampManagement.model;
import org.CampManagement.model.Subject;
public enum SubjectEnum {
    JAVA(1, SubjectType.MANDATORY, "JAVA"),
    UXUI(2, SubjectType.MANDATORY, "UXUI"),
    NODEJS(3, SubjectType.MANDATORY, "NODEJS"),
    AI(4, SubjectType.MANDATORY, "AI"),
    REACT(5, SubjectType.SELECTIVE, "REACT"),
    ANDROID(6, SubjectType.SELECTIVE, "ANDROID"),
    DATA(7, SubjectType.SELECTIVE, "DATA");


    private final int subjectId;
    private final SubjectType subjectType;
    private final String subjectName;

    SubjectEnum(int subjectId, SubjectType subjectType, String subjectName) {
        this.subjectId = subjectId;
        this.subjectType = subjectType;
        this.subjectName = subjectName;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public SubjectEnum getSubjectName() {
        return SubjectEnum.valueOf(subjectName);
    }
    public enum SubjectType {
        MANDATORY,
        SELECTIVE
    }
}