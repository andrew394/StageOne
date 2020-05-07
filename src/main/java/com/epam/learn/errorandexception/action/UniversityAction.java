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
            throw new StudentException("Student " + student.getSurname() + " doesn't have subjects");
        }
        for(Map.Entry<Subject, List<Integer>> entry : subjectMap.entrySet()) {
            List<Integer> value = entry.getValue();
            for (Integer score: value) {
                if (score < 0 || score > 10) {
                    throw new SubjectException("Student " + student.getSurname() + " has score below 0 or above 10");
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
            throw new GroupException("There are no students in the group " + group.getGroupNameType());
        }
        for (Student student : studentGroupList) {
            Map<Subject, List<Integer>> subjectMap = student.getSubjectScoreMap();
            if (subjectMap == null || subjectMap.isEmpty()) {
                throw new StudentException("Student " + student.getSurname() + " doesn't have subjects");
            }
            for(Map.Entry<Subject, List<Integer>> entry : subjectMap.entrySet()) {
                Subject key = entry.getKey();
                List<Integer> value = entry.getValue();
                if (key.equals(subject)) {
                    for (Integer score: value) {
                        if (score < 0 || score > 10) {
                            throw new SubjectException("Student " + student.getSurname() + " has score below 0 or above 10");
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
            throw new FacultyException("There are no groups at the faculty " + faculty.getFacultyNameType());
        }
        for (Group group : groupList) {
            List<Student> studentGroupList = group.getStudents();
            if (studentGroupList == null || studentGroupList.isEmpty()) {
                throw new GroupException("There are no students in the group " + group.getGroupNameType());
            }
            for (Student student : studentGroupList) {
                Map<Subject, List<Integer>> subjectMap = student.getSubjectScoreMap();
                if (subjectMap == null || subjectMap.isEmpty()) {
                    throw new StudentException("Student " + student.getSurname() + " doesn't have subjects");
                }
                for (Map.Entry<Subject, List<Integer>> entry : subjectMap.entrySet()) {
                    Subject key = entry.getKey();
                    List<Integer> value = entry.getValue();
                    if (key.equals(subject)) {
                        for (Integer score: value) {
                            if (score < 0 || score > 10) {
                                throw new SubjectException("Student " + student.getSurname() + " has score below 0 or above 10");
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
            throw new UniversityException("There are no faculties at the university");
        }
        for (Faculty faculty : facultyList) {
            List<Group> groupList = faculty.getGroups();
            if (groupList == null || groupList.isEmpty()) {
                throw new FacultyException("There are no groups at the faculty " + faculty.getFacultyNameType());
            }
            for (Group group : groupList) {
                List<Student> studentGroupList = group.getStudents();
                if (studentGroupList == null || studentGroupList.isEmpty()) {
                    throw new GroupException("There are no students in the group " + group.getGroupNameType());
                }
                for (Student student : studentGroupList) {
                    Map<Subject, List<Integer>> subjectMap = student.getSubjectScoreMap();
                    if (subjectMap == null || subjectMap.isEmpty()) {
                        throw new StudentException("Student " + student.getSurname() + " doesn't have subjects");
                    }
                    for (Map.Entry<Subject, List<Integer>> entry : subjectMap.entrySet()) {
                        Subject key = entry.getKey();
                        List<Integer> value = entry.getValue();
                        if (key.equals(subject)) {
                            for (Integer score: value) {
                                if (score < 0 || score > 10) {
                                    throw new SubjectException("Student " + student.getSurname() + " has score below 0 or above 10");
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
