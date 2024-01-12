package org.CampManagement.service;

import java.util.Scanner;
import org.CampManagement.store.ScoreStore;

public class ScoreService {

    private static final Scanner scanner = new Scanner(System.in);
    private ScoreStore scoreStore;

    public void registerScore() {
        System.out.println("수강생 id를 입력 해 주세요");
        int readId = readStudentId();

        //List<Integer> studentIds = studentService.getStudentId
        //if(!studentsIds.contains(readId) {
//            throw new IllegalArgumentException("없는 id입니다");
//        }



    }

    public int readStudentId() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요");
        }
    }
}
