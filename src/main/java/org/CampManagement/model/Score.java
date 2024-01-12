package org.CampManagement.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Score {

    private static final Pattern NUMBER = Pattern.compile("^[0-9]*$");
    private final int scoreId;
    private final int studentId;
    private final int subjectId;
    private int round;
    private int score;
    private String grade;

    public Score(int scoreId, int studentId, int subjectId, int round, int score, String grade) {
        this.scoreId = scoreId;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.round = round;
        this.score = score;
        this.grade = grade;
    }

    public Score(int scoreId, int studentId, int subjectId, String text, SubjectEnum subjectEnum) {
        this.studentId = studentId;
        this.scoreId = scoreId;
        this.subjectId = subjectId;
        int[] parsed = parse(text);
        this.round = parsed[0];
        this.score = parsed[1];
        this.grade = assignGrade(parsed[1], subjectEnum);
    }

    private int[] parse(String text) {
        if (text.isEmpty()) {
            throw new IllegalArgumentException("올바른 입력이 아닙니다");
        }
        String[] split = text.replace(" ","").split(",");
        for (String token : split) {
            validateNumeric(token);
        }
        int round = Integer.parseInt(split[0]);
        int score = Integer.parseInt(split[1]);
        if (round < 1 || round > 10) {
            throw new IllegalArgumentException("없는 회차입니다");
        }
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("없는 점수입니다");
        }
        return new int[] {round, score};
    }

    private void validateNumeric(String token) {
        Matcher matcher = NUMBER.matcher(token);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("올바른 입력이 아닙니다");
        }
    }

    private String assignGrade(int score, SubjectEnum subjectEnum) {
        String grade = "";
        //if mandatory
        if (95 <= score && score <= 100) {
            grade = "A";
        } else if (90 <= score && score <= 94) {
            grade = "B";
        } else if (80 <= score && score <= 89) {
            grade = "B";
        } else if (70 <= score && score <= 79) {
            grade = "B";
        } else if (60 <= score && score <= 69) {
            grade = "B";
        } else {
            grade = "N";
        }
        //if choice

        return grade;
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
}
