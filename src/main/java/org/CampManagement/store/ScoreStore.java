package org.CampManagement.store;

import org.CampManagement.model.Score;

import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

public class ScoreStore {
    private List<Score> list = new ArrayList<>();

    public void add(Score score) {
        validate(score);
        list.add(score);
    }

    private void validate(Score score) {
        int studentId = score.getStudentId();
        if (!isInStore(studentId)) {
            return;
        }
        Score found = findByStudentId(studentId);
        if (score.getSubjectId() == found.getSubjectId()
                && score.getRound() == found.getRound()) {
            throw new IllegalArgumentException("이미 있는 회차입니다");
        }
    }

    private Score findByStudentId(int studentId) {
        return list.stream()
                .filter(score -> score.getStudentId() == studentId)
                .findAny()
                .orElseThrow(IllegalAccessError::new);
    }

    public boolean isInStore(int studentId) {
        return list.stream()
                .map(Score::getStudentId)
                .anyMatch(id -> id == studentId);
    }

    public void updateScore(int studentId, int subjectId, int round, int score, String type) {
        Score target = null;
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (studentId ==(list.get(i).getStudentId()) && subjectId == (list.get(i).getSubjectId())) {
                target = list.get(i);
                index = i;
            }
        }

        target.updateScore(round, score, type);
        list.set(index, target);
    }

    public String getGradeByIdAndSubjectAndSession(int studentId, int subjectId, int session) {
        for (Score score : list) {
            if (score.getStudentId() == studentId && score.getSubjectId() == subjectId && score.getRound() == session) {
                return score.getGrade();
            }
        }
        throw new IllegalArgumentException("해당 학생 ID, 과목 ID, 회차에 대한 점수가 없습니다.");
    }

    public List<String> getGradesBySubject(int studentId, int subjectId) {
        List<String> grades = new ArrayList<>();

        for (Score score : list) {
            if (score.getStudentId() == studentId && score.getSubjectId() == subjectId) {
                grades.add(score.getGrade());
            }
        }

        if (grades.isEmpty()) {
            throw new IllegalArgumentException("해당 학생 ID와 과목 ID에 대한 점수가 없습니다.");
        }

        return grades;
    }


    public List<Score> getScoresByStudentId(int studentId) {
        List<Score> studentScores = new ArrayList<>();

        for (Score score : list) {
            if (score.getStudentId() == studentId) {
                studentScores.add(score);
            }
        }

        if (studentScores.isEmpty()) {
            throw new IllegalArgumentException("해당 학생 ID에 대한 점수가 없습니다.");
        }

        return studentScores;
    }

}
