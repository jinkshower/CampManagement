package org.CampManagement.model;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private int subjectId;
    private String subjectType;
    private int studentId;
    private String subjectName;
    private List<String> grades;  // 추가: 회차별 등급 정보를 저장할 리스트

    public Subject(int subjectId, int studentId, String subjectType, String subjectName) {
        this.subjectId = subjectId;
        this.studentId = studentId;
        this.subjectType = subjectType;
        this.subjectName = subjectName;
        this.grades = new ArrayList<>();  // 초기화
    }

    public Subject(int subjectId, String subjectType, String subjectName) {
        this.subjectId = subjectId;
        this.subjectType = subjectType;
        this.subjectName = subjectName;
        this.grades = new ArrayList<>();  // 초기화
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


    public List<String> getGrades() {
        return grades;
    }

    public void addGrade(String grade) {
        this.grades.add(grade);
    }
}
