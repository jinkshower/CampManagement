package org.CampManagement.model;

public class Subject {

    private int subjectId;
    private SubjectEnum.SubjectType subjectType;
    private int studentId;
    private final SubjectEnum subjectName;

    public Subject(int subjectId, int studentId, SubjectEnum.SubjectType subjectType, SubjectEnum subjectName) {
        this.subjectId = subjectId;
        this.studentId = studentId;
        this.subjectType = subjectType;
        this.subjectName = subjectName;
    }



    public int getSubjectId() {
        return subjectId;
    }

    public int getStudentId() {
        return studentId;
    }

    public SubjectEnum.SubjectType getSubjectType() {
        return subjectType;
    }

    public SubjectEnum getSubjectName() {
        return subjectName;
    }
}
