package org.CampManagement;

import org.CampManagement.model.Student;
import org.CampManagement.service.ScoreService;
import org.CampManagement.service.StudentService;
import org.CampManagement.service.SubjectService;
import org.CampManagement.store.SubjectStore;
import org.CampManagement.model.SubjectEnum;
import java.util.Scanner;

public class ManagementApp {
    public static void main(String[] args) {
        updateStudent();
    }
    static void updateStudent(){
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
                    SubjectStore.saveSubject(subjectEnum.getSubjectId(), studentId,
                            subjectEnum.getSubjectType(), subjectEnum.getSubjectName());
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

