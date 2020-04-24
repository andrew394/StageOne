package com.epam.learn.errorandexception.action;

import com.epam.learn.errorandexception.entity.*;
import com.epam.learn.errorandexception.exception.*;

import java.util.List;
import java.util.Map;

public class UniversityAction {

    public double averageScoreByStudent(Student student) throws SubjectException, StudentException {
        int sum = 0;
        int countScore = 0;
        Map<Subject, List<Integer>> subjectMap = student.getSubjectScoreMap();
        if (subjectMap == null || subjectMap.isEmpty()) {
            throw new StudentException("Отсутсвие предметов у студента " + student.getSurname());
        }
        for(Map.Entry<Subject, List<Integer>> entry : subjectMap.entrySet()) {
            List<Integer> value = entry.getValue();
            for (Integer score: value) {
                if (score < 0 || score > 10) {
                    throw new SubjectException("Оценка ниже 0 или выше 10 у студента " + student.getSurname());
                }
                sum += score;
            }
            countScore += value.size();
        }
       return countScore == 0 ? 0 : (double)sum/countScore;
    }

    public double averageScoreBySubjectInGroup(Group group, Subject subject) throws
            SubjectException, StudentException, GroupException {
        int sumScoreInGroup = 0;
        int countScoreOnSubject = 0;
        List<Student> studentGroupList = group.getStudents();
        if (studentGroupList == null || studentGroupList.isEmpty()) {
            throw new GroupException("Отсутствие студентов в группе " + group.getGroupNameType());
        }
        for (Student student : studentGroupList) {
            Map<Subject, List<Integer>> subjectMap = student.getSubjectScoreMap();
            if (subjectMap == null || subjectMap.isEmpty()) {
                throw new StudentException("Отсутсвие предметов у студента " + student.getSurname());
            }
            for(Map.Entry<Subject, List<Integer>> entry : subjectMap.entrySet()) {
                Subject key = entry.getKey();
                List<Integer> value = entry.getValue();
                if (key.equals(subject)) {
                    for (Integer score: value) {
                        if (score < 0 || score > 10) {
                            throw new SubjectException("Оценка ниже 0 или выше 10 у студента " + student.getSurname());
                        }
                        sumScoreInGroup += score;
                    }
                    countScoreOnSubject += value.size();
                }
            }
        }
        return countScoreOnSubject == 0 ? 0 : (double)sumScoreInGroup/countScoreOnSubject;
    }

    public double averageScoreBySubjectInFaculty(Faculty faculty, Subject subject) throws
            SubjectException, StudentException, GroupException, FacultyException {
        int sumScoreInFaculty = 0;
        int countScoreOnSubject = 0;
        List<Group> groupList = faculty.getGroups();
        if (groupList == null || groupList.isEmpty()) {
            throw new FacultyException("Отсутствие групп на факультете " + faculty.getFacultyNameType());
        }
        for (Group group : groupList) {
            List<Student> studentGroupList = group.getStudents();
            if (studentGroupList == null || studentGroupList.isEmpty()) {
                throw new GroupException("Отсутствие студентов в группе " + group.getGroupNameType());
            }
            for (Student student : studentGroupList) {
                Map<Subject, List<Integer>> subjectMap = student.getSubjectScoreMap();
                if (subjectMap == null || subjectMap.isEmpty()) {
                    throw new StudentException("Отсутсвие предметов у студента " + student.getSurname());
                }
                for (Map.Entry<Subject, List<Integer>> entry : subjectMap.entrySet()) {
                    Subject key = entry.getKey();
                    List<Integer> value = entry.getValue();
                    if (key.equals(subject)) {
                        for (Integer score: value) {
                            if (score < 0 || score > 10) {
                                throw new SubjectException("Оценка ниже 0 или выше 10 у студента " + student.getSurname());
                            }
                            sumScoreInFaculty += score;
                        }
                        countScoreOnSubject += value.size();
                    }
                }
            }
        }
        return countScoreOnSubject == 0 ? 0 : (double)sumScoreInFaculty/countScoreOnSubject;
    }

    public double averageScoreBySubjectInUniversity(University university, Subject subject) throws
            SubjectException, StudentException, GroupException, FacultyException, UniversityException {
        int sumScoreInUniversity = 0;
        int countScoreOnSubject = 0;
        List<Faculty> facultyList = university.getFaculties();
        if (facultyList == null || facultyList.isEmpty()) {
            throw new UniversityException("Отсутствие факультетов в университете");
        }
        for (Faculty faculty : facultyList) {
            List<Group> groupList = faculty.getGroups();
            if (groupList == null || groupList.isEmpty()) {
                throw new FacultyException("Отсутствие групп на факультете " + faculty.getFacultyNameType());
            }
            for (Group group : groupList) {
                List<Student> studentGroupList = group.getStudents();
                if (studentGroupList == null || studentGroupList.isEmpty()) {
                    throw new GroupException("Отсутствие студентов в группе " + group.getGroupNameType());
                }
                for (Student student : studentGroupList) {
                    Map<Subject, List<Integer>> subjectMap = student.getSubjectScoreMap();
                    if (subjectMap == null || subjectMap.isEmpty()) {
                        throw new StudentException("Отсутсвие предметов у студента " + student.getSurname());
                    }
                    for (Map.Entry<Subject, List<Integer>> entry : subjectMap.entrySet()) {
                        Subject key = entry.getKey();
                        List<Integer> value = entry.getValue();
                        if (key.equals(subject)) {
                            for (Integer score: value) {
                                if (score < 0 || score > 10) {
                                    throw new SubjectException("Оценка ниже 0 или выше 10 у студента " + student.getSurname());
                                }
                                sumScoreInUniversity += score;
                            }
                            countScoreOnSubject += value.size();
                        }
                    }
                }
            }
        }
        return countScoreOnSubject == 0 ? 0 : (double)sumScoreInUniversity/countScoreOnSubject;
    }
}
