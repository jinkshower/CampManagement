package org.CampManagement.store;

import org.CampManagement.model.Score;

import java.util.ArrayList;
import java.util.List;
import org.CampManagement.model.Student;

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

    private boolean isInStore(int studentId) {
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

}
