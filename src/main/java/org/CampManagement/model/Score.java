package org.CampManagement.model;

public class Score {

    private final int scoreId;
    private final int studentId;
    private final int subjectId;
    private int round;
    private String grade;
    private int score;

    public Score(int scoreId, int studentId, int subjectId, int round, int score) {
        this.scoreId = scoreId;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.round = round;
//        this.grade = grade;
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

    public String getGrade() {
        return grade;
    }

    public int getScore() {
        return score;
    }

    public void updateScore(int round, int score, String type) {
        this.round = round;
        this.score = score;
        this.grade = type.equals("Mandatory") ? calcMandatoryGrade(score) : calcChoiceGrade(score);
    }

    public String calcChoiceGrade(int score) {
        return switch (score / 10) {
            case 10, 9 -> "A";
            case 8 -> "B";
            case 7 -> "C";
            case 6 -> "D";
            case 5 -> "F";
            default -> "N";
        };
    }

    public String calcMandatoryGrade(int score) {
        String grade = "";
        if (score >= 95) return "A";
        if (score >= 90) return "B";
        if (score >= 80) return "C";
        if (score >= 70) return "D";
        if (score >= 60) return "D";

        return "N";
    }
}
