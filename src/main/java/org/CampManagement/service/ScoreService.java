package org.CampManagement.service;

import java.util.Scanner;
import org.CampManagement.model.Score;
import org.CampManagement.model.Subject;
import org.CampManagement.store.ScoreStore;
import org.CampManagement.store.SubjectStore;


public class ScoreService {

    private static final Scanner scanner = new Scanner(System.in);
    private static int SCORE_INDEX = 0;
    private ScoreStore scoreStore = new ScoreStore();
    private StudentService studentService;

    public ScoreService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void registerScore() {
        System.out.println("수강생 id를 입력 해 주세요");
        int readId = readInt();

        studentService.validateId(readId);

        System.out.println("과목을 입력해주세요");

        String readSubject = readText();
        SubjectService.isValidSubject(readSubject);
        Subject foundSubject = SubjectStore.getSubjectByIdAndName(readId, readSubject);

        System.out.println("회차, 점수를 입력해주세요");
        String input = readText();
        Score score = new Score(++SCORE_INDEX, readId,
                foundSubject.getSubjectId(), input, foundSubject.getSubjectType());
        scoreStore.add(score);
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

    public boolean updateScore(int studentId, int subjectId, int round, int score) {
        if (round < 0 || round > 10) {
            return false;
        }

        if (score < 0 || score > 100) {
            return false;
        }

        // 없는 과목 예외
        if (!SubjectService.validateSubjectByStudentId(studentId, subjectId)) {
            return false;
        }

        SubjectStore subjectStore = new SubjectStore();
        String type = subjectStore.getType(studentId, subjectId);

        // 없는 회차 예외
        return scoreStore.updateScore(studentId, subjectId, round, score, type);
    }


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
