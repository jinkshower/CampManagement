package org.CampManagement.model;

public class Subject {

    private int subjectId;
    private String subjectType;
    private int studentId;
    private String subjectName;

    public Subject(int subjectId, int studentId, String subjectType, String subjectName) {
        this.subjectId = subjectId;
        this.studentId = studentId;
        this.subjectType = subjectType;
        this.subjectName = subjectName;
    }

    public Subject(int subjectId, String subjectType, String subjectName) {
        this.subjectId = subjectId;
        this.subjectType = subjectType;
        this.subjectName = subjectName;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public String getSubjectName() {
        return subjectName;
    }
}
