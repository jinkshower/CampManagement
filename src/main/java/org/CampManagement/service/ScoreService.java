package org.CampManagement.service;

import org.CampManagement.store.ScoreStore;
import org.CampManagement.store.SubjectStore;

public class ScoreService {
    private static ScoreStore scoreStore = new ScoreStore();

    public boolean updateScore(int studentId, int subjectId, int round, int score) {

        if (round < 0 || round > 10) {
            return false;
        }

        if (score < 0 || score > 100) {
            return false;
        }

        SubjectStore subjectStore = new SubjectStore();
        String type = subjectStore.getType(studentId, subjectId);

        scoreStore.updateScore(studentId, subjectId, round, score, type);
        return true;
    }
}
