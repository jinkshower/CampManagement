package org.CampManagement.model;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.CampManagement.model.Subject;
public enum SubjectEnum {
    JAVA(1, "필수", "JAVA"),
    UXUI(2, "필수", "UXUI"),
    NODEJS(3, "필수", "NODEJS"),
    AI(4, "필수", "AI"),
    REACT(5, "선택", "REACT"),
    ANDROID(6, "선택", "ANDROID"),
    DATA(7, "선택", "DATA");


    private final int subjectId;
    private final String subjectType;
    private final String subjectName;

    SubjectEnum(int subjectId, String subjectType, String subjectName) {
        this.subjectId = subjectId;
        this.subjectType = subjectType;
        this.subjectName = subjectName;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getMessage() {
        return subjectType + " " + subjectName;
    }

    public static String getSubjectsTypeAndName() {
        return Arrays.stream(values())
                .map(SubjectEnum::getMessage)
                .collect(Collectors.joining("\n"));
    }
}
