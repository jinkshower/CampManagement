package org.CampManagement;

import org.CampManagement.model.Student;
import org.CampManagement.service.ScoreService;
import org.CampManagement.service.StudentService;
import org.CampManagement.service.SubjectService;
import org.CampManagement.store.StudentStore;
import org.CampManagement.model.SubjectEnum;
import org.CampManagement.store.SubjectStore;

import java.util.Scanner;

public class ManagementApp {

    private static StudentService studentService;
    private static SubjectService subjectService;
    private static ScoreService scoreService;



    public static void main(String[] args) {
        StudentStore studentStore = new StudentStore();
        studentService = new StudentService(studentStore);
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

    public ManagementApp() {



        studentService.addStudent(new Student(1, "John Doe"));
        studentService.addStudent(new Student(2, "Jane Doe"));
    }

    private void printStudentList() {
        System.out.println("Printing Student List:");
        studentService.printStudentListWithIds();
    }

    private void printStudentNamesWithIds() {
        System.out.println("\nPrinting Student Names with IDs:");
        for (String studentInfo : studentService.getStudentListWithIds()) {
            System.out.println(studentInfo);
        }
    }
    static void updateStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("이름을 입력하세요: ");
        String name = scanner.nextLine();

        // StudentService를 사용하여 학생 ID 생성
        int studentId = StudentService.generateStudentId();
        StudentService.saveStudent(name);

        System.out.print("과목을 입력하세요 (쉼표로 구분): ");
        String[] subjects = scanner.nextLine().split(",");

        try {
            // 필수과목이 3개 미만이면 예외 처리
            SubjectService.validateMandatorySubjects(subjects);
            // 선택과목이 2개 미만이면 예외 처리
            SubjectService.validateSelectiveSubjects(subjects);

            // 입력받은 과목을 SubjectService를 사용하여 SubjectEnum에 저장된 과목인지 확인하고 저장
            for (String subject : subjects) {
                if (SubjectService.isValidSubject(subject.trim())) {
                    SubjectEnum subjectEnum = SubjectEnum.valueOf(subject.trim().toUpperCase());
                   // SubjectStore.saveSubject(subjectEnum.getSubjectId(), studentId,
                     //       subjectEnum.getSubjectType(), subjectEnum.getSubjectName());
                } else {
                    System.out.println("유효하지 않은 과목: " + subject.trim());
                }
            }

        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

