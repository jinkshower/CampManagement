package org.CampManagement;

import org.CampManagement.model.Student;
import org.CampManagement.model.Subject;
import org.CampManagement.service.ScoreService;
import org.CampManagement.service.StudentService;
import org.CampManagement.service.SubjectService;
import org.CampManagement.model.SubjectEnum;

import java.util.Scanner;
import org.CampManagement.store.SubjectStore;

public class ManagementApp {

    private static StudentService studentService = new StudentService();
    private static SubjectService subjectService = new SubjectService();
    private static ScoreService scoreService = new ScoreService(studentService);
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        startManagement();
    }

    private static void startManagement() {
        System.out.println("1. 수강생 관리");
        System.out.println("2. 점수 관리");

        String str = sc.nextLine();

        if ("1".equals(str)) {
            manageStudent();
        } else if("2".equals(str)){
            manageScore();
        } else {
            startManagement();
        }
    }

    private static void manageStudent() {
        System.out.println("1. 수강생등록");
        System.out.println("2. 수강생조회");
        System.out.println("3. 수강생수정");

        String str = sc.nextLine();

        if (str.equals("1")) {
            updateStudent();
        } else if (str.equals("2")){
            displayStudentInfo();
        } else if (str.equals("3")){
            adjustStudent();
        } else {
            manageStudent();
        }
    }

    private static void manageScore() {
        System.out.println("1. 점수 등록");
        System.out.println("2. 점수 수정");
        System.out.println("3. 점수 조회");

        String str = sc.nextLine();

        if (str.equals("1")) {
            scoreService.registerScore();
            startManagement();
        } else if (str.equals("2")) {
            updateScore();
        } else if (str.equals("3")) {
            displayScoreDetails();
        } else {
            manageScore();
        }
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

        System.out.println("과목명을 입력 해주세요");
        String text = sc.nextLine();
        Subject foundSubject = SubjectStore.getSubjectByIdAndName(id, text);

        System.out.println("회차와 점수를 입력해주세요 ex) 1, 100");
        String[] str = sc.nextLine().split(",");
        int round = Integer.parseInt(str[0].trim());
        int score = Integer.parseInt(str[1].trim());
        if (!scoreService.updateScore(id, foundSubject.getSubjectId(), round, score)) {
            System.out.println("입력오류입니다");
            startManagement();
        }

        System.out.println("수정이 완료되었습니다.");
        System.out.println("===========================");

        startManagement();
    }

    private static void displayStudentInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("수강생 ID를 입력하세요: ");
        int studentId = scanner.nextInt();

        if (studentService.validateId(studentId)) {
            System.out.println("ID: " + studentId + ", 이름: " + studentService.getStudentName(studentId));
            //과목 조회 추가 TO DO
        } else {
            System.out.println("해당 ID의 수강생이 존재하지 않습니다.");
        }
        System.out.println("=============================");

        startManagement();
    }

    private static void displayScoreDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("수강생 ID를 입력하세요: ");
        int studentId = Integer.parseInt(scanner.nextLine());

        if (!studentService.validateId(studentId)) {
            System.out.println("해당 ID의 수강생이 존재하지 않습니다.");
            return;
        }

        System.out.println("과목명을 입력 해주세요");
        String text = sc.nextLine();
        Subject foundSubject = SubjectStore.getSubjectByIdAndName(studentId, text);


        System.out.println("회차를 입력하세요: ");
        int round = scanner.nextInt();

        String grade = scoreService.getGradeByIdAndSubjectAndSession(studentId, foundSubject.getSubjectId(), round);

        if (grade != null) {
            System.out.println("등급: " + grade);
        } else {
            System.out.println("해당 정보에 대한 등급이 존재하지 않습니다.");
        }

        System.out.println("===========================");

        startManagement();
    }

    static void updateStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("이름을 입력하세요: ");
        String name = scanner.nextLine();

        // StudentService를 사용하여 학생 ID 생성
        int studentId = studentService.generateStudentId();
        System.out.print("과목을 입력하세요 (쉼표로 구분): ");
        String[] subjects = scanner.nextLine().split(",");

        try {
            // 필수과목이 3개 미만이면 예외 처리
            SubjectService.validateMandatorySubjects(subjects);
            // 선택과목이 2개 미만이면 예외 처리
            SubjectService.validateSelectiveSubjects(subjects);
            studentService.saveStudent(name, studentId);
            // 입력받은 과목을 SubjectService를 사용하여 SubjectEnum에 저장된 과목인지 확인하고 저장
            for (String subject : subjects) {
                if (SubjectService.isValidSubject(subject.trim())) {
                    SubjectEnum subjectEnum = SubjectEnum.valueOf(subject.trim().toUpperCase());
                    SubjectStore.saveSubject(subjectEnum.getSubjectId(), studentId,
                            subjectEnum.getSubjectType(), subjectEnum.getSubjectName());
                } else {
                    System.out.println("유효하지 않은 과목: " + subject.trim());
                }
            }

        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        startManagement();
    }

    // 학생 이름 수정
    private static void adjustStudent() {
        System.out.println("학생 아이디를 입력하세요");
        int studentId = Integer.parseInt(sc.nextLine());

        if (!studentService.isValidStudentId(studentId)) {
            System.out.println("없는 학생입니다.");
            startManagement();
        }

        System.out.println("수정할 이름을 입력해주세요");
        String updateName = sc.nextLine();

        Student student = studentService.updateStudent(studentId, updateName);

        System.out.println(student.getStudentId() + ", " + student.getName());
        System.out.println("수정이 완료되었습니다.");
        startManagement();

    }
}

