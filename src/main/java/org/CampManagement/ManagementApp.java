package org.CampManagement;

import org.CampManagement.model.Student;
import org.CampManagement.service.ScoreService;
import org.CampManagement.service.StudentService;
import org.CampManagement.service.SubjectService;
import org.CampManagement.store.StudentStore;

import java.util.Scanner;

public class ManagementApp {

    private static StudentService studentService;
    private static SubjectService subjectService;
    private static ScoreService scoreService;



    public static void main(String[] args) {
    }

    static void updateScore() {
        Scanner sc = new Scanner(System.in);
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

    private void displayStudentInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("수강생 ID를 입력하세요: ");
        int studentId = scanner.nextInt();

        if (studentService.validateId(studentId)) {
            System.out.println("ID: " + studentId + ", 이름: " + studentService.getStudentName(studentId));

        } else {
            System.out.println("해당 ID의 수강생이 존재하지 않습니다.");
        }
        System.out.println("=============================");
    }

    private void displayScoreDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("수강생 ID를 입력하세요: ");
        int studentId = scanner.nextInt();

        if (!studentService.validateId(studentId)) {
            System.out.println("해당 ID의 수강생이 존재하지 않습니다.");
            return;
        }

        System.out.println("과목 ID를 입력하세요: ");
        int subjectId = scanner.nextInt();

        if (!subjectService.validateSubjectId(subjectId)) {
            System.out.println("해당 ID의 과목이 존재하지 않습니다.");
            return;
        }

        System.out.println("회차를 입력하세요: ");
        int round = scanner.nextInt();

        String grade = scoreService.getGradeByIdAndSubjectAndSession(studentId, subjectId, round);

        if (grade != null) {
            System.out.println("등급: " + grade);
        } else {
            System.out.println("해당 정보에 대한 등급이 존재하지 않습니다.");
        }

        System.out.println("===========================");
    }
}
