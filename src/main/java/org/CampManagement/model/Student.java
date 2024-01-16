package org.CampManagement.model;

public class Student {

    private final int studentId;
    private String name;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    // 학생 이름 수정
    public void updateName(String updateName) {
        this.name = updateName;
    }
}
