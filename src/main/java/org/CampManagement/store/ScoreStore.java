package org.CampManagement.store;

import org.CampManagement.model.Score;

import java.util.ArrayList;
import java.util.List;

public class ScoreStore {
    private List<Score> list = new ArrayList<>();

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
