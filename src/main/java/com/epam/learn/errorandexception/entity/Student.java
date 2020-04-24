package com.epam.learn.errorandexception.entity;

import java.util.List;
import java.util.Map;

public class Student {

    private String surname;
    Map<Subject, List<Integer>> subjectScoreMap;

    public Student(String surname, Map<Subject, List<Integer>> subjectScoreMap) {
        this.surname = surname;
        this.subjectScoreMap = subjectScoreMap;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Map<Subject, List<Integer>> getSubjectScoreMap() {
        return subjectScoreMap;
    }

    public void setSubjectScoreMap(Map<Subject, List<Integer>> subjectScoreMap) {
        this.subjectScoreMap = subjectScoreMap;
    }

    @Override
    public String toString() {
        return "Student{" +
                "surname='" + surname + '\'' +
                ", subjectScoreMap=" + subjectScoreMap +
                '}';
    }
}
