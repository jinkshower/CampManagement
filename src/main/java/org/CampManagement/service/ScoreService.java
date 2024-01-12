package org.CampManagement.service;

import java.util.Scanner;
import org.CampManagement.store.ScoreStore;

public class ScoreService {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String SCORE_PREFIX = "SC";
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
        System.out.println("회차, 점수를 입력해주세요");
        String input = readText();

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
}
