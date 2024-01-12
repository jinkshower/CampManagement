package org.CampManagement.service;

import org.CampManagement.store.ScoreStore;
import org.CampManagement.store.SubjectStore;

public class ScoreService {
    private static ScoreStore scoreStore = new ScoreStore();

    public boolean updateScore(int studentId, int subjectId, int round, int score) {


        SubjectStore subjectStore = new SubjectStore();
        String type = subjectStore.getType(studentId, subjectId);

        scoreStore.updateScore(studentId, subjectId, round, score, type);
        return true;
    }
}
