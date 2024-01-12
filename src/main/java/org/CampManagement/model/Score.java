package org.CampManagement.model;

public class Score {

    private final int scoreId;
    private final int studentId;
    private final int subjectId;
    private int round;
    private int grade;
    private int score;

    public Score(int scoreId, int studentId, int subjectId, int round, int grade, int score) {
        this.scoreId = scoreId;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.round = round;
        this.grade = grade;
        this.score = score;
    }

    public int getScoreId() {
        return scoreId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public int getRound() {
        return round;
    }

    public int getGrade() {
        return grade;
    }

    public int getScore() {
        return score;
    }
}
