package com.epam.learn.errorandexception;

import com.epam.learn.errorandexception.action.UniversityAction;
import com.epam.learn.errorandexception.data.FacultyData;
import com.epam.learn.errorandexception.data.GroupData;
import com.epam.learn.errorandexception.data.StudentData;
import com.epam.learn.errorandexception.entity.*;
import com.epam.learn.errorandexception.exception.*;

import java.util.List;

public class UniversityRunner {

    public static void main(String[] args) {

        UniversityAction universityAction = new UniversityAction();
        List<Student> students = new StudentData().dataStudents();
        List<Group> groups = new GroupData().dataGroups();
        List<Faculty> faculties = new FacultyData().dataFaculties();

//The average score for all subjects of the student
        System.out.println("THE AVERAGE SCORE FOR ALL SUBJECTS OF THE STUDENT:");
        students.forEach(s ->
        {
            try {
                System.out.println(s.getSurname() + " average score = " +  universityAction.averageScoreByStudent(s));
            } catch (SubjectException | StudentException e) {
                e.printStackTrace();
            }
        });

//The average score for a specific subject in a particular group
        System.out.println("THE AVERAGE SCORE FOR A SPECIFIC SUBJECT IN A PARTICULAR GROUP:");
        groups.forEach(g ->
        {
            try {
                System.out.println("In the " + g.getGroupNameType() + " group the average score in " +  SubjectNameType.MATH + " = " +
                        universityAction.averageScoreBySubjectInGroup(g, new Subject(SubjectNameType.MATH)));
            } catch (SubjectException | StudentException | GroupException e) {
                e.printStackTrace();
            }
        });
        groups.forEach(g ->
        {
            try {
                System.out.println("In the " + g.getGroupNameType() + " group the average score in " +  SubjectNameType.INFORMATICS + " = " +
                        universityAction.averageScoreBySubjectInGroup(g, new Subject(SubjectNameType.INFORMATICS)));
            } catch (SubjectException | StudentException | GroupException e) {
                e.printStackTrace();
            }
        });
        groups.forEach(g ->
        {
            try {
                System.out.println("In the " + g.getGroupNameType() + " group the average score in " +  SubjectNameType.PHYSICS + " = " +
                        universityAction.averageScoreBySubjectInGroup(g, new Subject(SubjectNameType.PHYSICS)));
            } catch (SubjectException | StudentException | GroupException e) {
                e.printStackTrace();
            }
        });

//The average score for a specific subject in a particular faculty
        System.out.println("THE AVERAGE SCORE FOR A SPECIFIC SUBJECT IN A PARTICULAR FACULTY:");
        faculties.forEach(f ->
        {
            try {
                System.out.println("In the faculty of " + f.getFacultyNameType() + " the average score in " +  SubjectNameType.MATH + " = " +
                        universityAction.averageScoreBySubjectInFaculty(f, new Subject(SubjectNameType.MATH)));
            } catch (SubjectException | StudentException | GroupException | FacultyException e) {
                e.printStackTrace();
            }
        });
        faculties.forEach(f ->
        {
            try {
                System.out.println("In the faculty of " + f.getFacultyNameType() + " the average score in " +  SubjectNameType.INFORMATICS + " = " +
                        universityAction.averageScoreBySubjectInFaculty(f, new Subject(SubjectNameType.INFORMATICS)));
            } catch (SubjectException | StudentException | GroupException | FacultyException e) {
                e.printStackTrace();
            }
        });
        faculties.forEach(f ->
        {
            try {
                System.out.println("In the faculty of " + f.getFacultyNameType() + " the average score in " +  SubjectNameType.PHYSICS + " = " +
                        universityAction.averageScoreBySubjectInFaculty(f, new Subject(SubjectNameType.PHYSICS)));
            } catch (SubjectException | StudentException | GroupException | FacultyException e) {
                e.printStackTrace();
            }
        });

//The average score for a specific subject in a university
        System.out.println("THE AVERAGE SCORE FOR A SPECIFIC SUBJECT IN A UNIVERSITY:");
        try {
            System.out.println("In a university the average score in " +  SubjectNameType.MATH + " = " +
                    universityAction.averageScoreBySubjectInUniversity(new University(faculties), new Subject(SubjectNameType.MATH)));
        } catch (SubjectException | StudentException | GroupException | FacultyException | UniversityException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("In a university the average score in " +  SubjectNameType.INFORMATICS + " = " +
                    universityAction.averageScoreBySubjectInUniversity(new University(faculties), new Subject(SubjectNameType.INFORMATICS)));
        } catch (SubjectException | StudentException | GroupException | FacultyException | UniversityException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("In a university the average score in " +  SubjectNameType.PHYSICS + " = " +
                    universityAction.averageScoreBySubjectInUniversity(new University(faculties), new Subject(SubjectNameType.PHYSICS)));
        } catch (SubjectException | StudentException | GroupException | FacultyException | UniversityException e) {
            e.printStackTrace();
        }
    }
}
