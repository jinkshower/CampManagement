package org.CampManagement;

import org.CampManagement.service.ScoreService;
import org.CampManagement.service.StudentService;
import org.CampManagement.service.SubjectService;

import java.util.Scanner;

public class ManagementApp {

    private static StudentService studentService = new StudentService();
    private static SubjectService subjectService = new SubjectService();
    private static ScoreService scoreService = new ScoreService();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        updateScore();
    }

    static void updateScore() {
        System.out.println("===========================");
        System.out.println("수강생 ID를 입력해주세요");
        int id = Integer.parseInt(sc.nextLine());

        if(!studentService.validateId(id)) {
            System.out.println("없는 아이디입니다.");
            updateScore();
        }

        System.out.println("과목ID를 입력해주세요");
        int subjectId = Integer.parseInt(sc.nextLine());

        System.out.println("회차와 점수를 입력해주세요 ex) 1, 100");
        String[] str = sc.nextLine().split(",");
        int round = Integer.parseInt(str[0].trim());
        int score = Integer.parseInt(str[1].trim());
        System.out.println("score = " + score);
        if (!scoreService.updateScore(id, subjectId, round, score)) {
            System.out.println("입력오류입니다");
            updateScore();
        }

        System.out.println("수정이 완료되었습니다.");
        System.out.println("===========================");
    }

}
