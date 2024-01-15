package org.CampManagement.service;

import java.util.Scanner;
import org.CampManagement.model.Score;
import org.CampManagement.model.SubjectEnum;
import org.CampManagement.store.ScoreStore;
import org.CampManagement.store.SubjectStore;
import java.util.List;


public class ScoreService {

    private static final Scanner scanner = new Scanner(System.in);
    private static int SCORE_INDEX = 0;
    private ScoreStore scoreStore;

    public void registerScore() {
        System.out.println("수강생 id를 입력 해 주세요");
        int readId = readInt();

        //List<Integer> studentIds = studentService.getStudentId
        //if(!studentsIds.contains(readId) {
//            throw new IllegalArgumentException("없는 id입니다");
//        }
        System.out.println("과목을 입력해주세요");
//        SubjectEnum subjectEnum = SubjectEnum.from(readSubject());
//        int subjectId = 0;

        System.out.println("회차, 점수를 입력해주세요");
        String input = readText();
//       Score score = new Score(++SCORE_INDEX, readId, subjectId,input, subjectEnum);
//        scoreStore.add(score);
    }

    public int readInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요");
        }
    }

    public String readText() {
        return scanner.nextLine();
    }

    private String sequence(String prefix) {
        SCORE_INDEX++;
        return prefix + SCORE_INDEX;
    }

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


//    public ScoreService(ScoreStore scoreStore) {
//        this.scoreStore = scoreStore;
//    }


    public String getGradeByIdAndSubjectAndSession(int studentId, int subject, int session) {
        try {
            return scoreStore.getGradeByIdAndSubjectAndSession(studentId, subject, session);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void getGradesBySubject(int studentId, int subject) {
        try {
            scoreStore.getGradesBySubject(studentId, subject);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getScoresByStudentId(int studentId) {
        try {
            scoreStore.getScoresByStudentId(studentId);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
