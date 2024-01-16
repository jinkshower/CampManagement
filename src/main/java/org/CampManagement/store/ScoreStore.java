package org.CampManagement.store;

import org.CampManagement.model.Score;

import java.util.ArrayList;
import java.util.List;

public class ScoreStore {
    private List<Score> scores = new ArrayList<>();

    public void add(Score score) {
        validate(score);
        scores.add(score);
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
        return scores.stream()
                .filter(score -> score.getStudentId() == studentId)
                .findAny()
                .orElseThrow(IllegalAccessError::new);
    }

    public boolean isInStore(int studentId) {
        return scores.stream()
                .map(Score::getStudentId)
                .anyMatch(id -> id == studentId);
    }

    public boolean updateScore(int studentId, int subjectId, int round, int score, String type) {
        Score target = null;
        int index = 0;

        // 없는 회차 예외
        boolean validRound = scores.stream()
                .anyMatch(s -> s.getStudentId() == studentId
                        && s.getSubjectId() == subjectId
                        && s.getRound() == round);

        if(!validRound) {
            return false;
        }

        for (int i = 0; i < scores.size(); i++) {
            if (studentId ==(scores.get(i).getStudentId()) && subjectId == (scores.get(i).getSubjectId())
            && scores.get(i).getRound() == round) {
                target = scores.get(i);
                index = i;
            }
        }

        target.updateScore(round, score, type);
        scores.set(index, target);
        return true;
    }

    public String getGradeByIdAndSubjectAndSession(int studentId, int subjectId, int session) {
        for (Score score : scores) {
            if (score.getStudentId() == studentId && score.getSubjectId() == subjectId && score.getRound() == session) {
                return score.getGrade();
            }
        }
        throw new IllegalArgumentException("해당 학생 ID, 과목 ID, 회차에 대한 점수가 없습니다.");
    }


}
