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

//Средний балл по всем предметам студента
        System.out.println("СРЕДНИЙ БАЛЛ ПО ВСЕМ ПРЕДМЕТАМ СТУДЕНТА:");
        students.forEach(s ->
        {
            try {
                System.out.println(s.getSurname() + " средний балл = " +  universityAction.averageScoreByStudent(s));
            } catch (SubjectException | StudentException e) {
                e.printStackTrace();
            }
        });

//Средний балл по конкретному предмету в конкретной группе
        System.out.println("СРЕДНИЙ БАЛЛ ПО КОНКРЕТНОМУ ПРЕДМЕТУ В КОНКРЕТНОЙ ГРУППЕ:");
        groups.forEach(g ->
        {
            try {
                System.out.println(g.getGroupNameType() + " группа, средний балл по " +  SubjectNameType.MATH + " = " +
                        universityAction.averageScoreBySubjectInGroup(g, new Subject(SubjectNameType.MATH)));
            } catch (SubjectException | StudentException | GroupException e) {
                e.printStackTrace();
            }
        });
        groups.forEach(g ->
        {
            try {
                System.out.println(g.getGroupNameType() + " группа, средний балл по " +  SubjectNameType.INFORMATICS + " = " +
                        universityAction.averageScoreBySubjectInGroup(g, new Subject(SubjectNameType.INFORMATICS)));
            } catch (SubjectException | StudentException | GroupException e) {
                e.printStackTrace();
            }
        });
        groups.forEach(g ->
        {
            try {
                System.out.println(g.getGroupNameType() + " группа, средний балл по " +  SubjectNameType.PHYSICS + " = " +
                        universityAction.averageScoreBySubjectInGroup(g, new Subject(SubjectNameType.PHYSICS)));
            } catch (SubjectException | StudentException | GroupException e) {
                e.printStackTrace();
            }
        });

//Средний балл по конкретному предмету на конкретном факультете
        System.out.println("СРЕДНИЙ БАЛЛ ПО КОНКРЕТНОМУ ПРЕДМЕТУ НА КОНКРЕТНОМ ФАКУЛЬТЕТЕ:");
        faculties.forEach(f ->
        {
            try {
                System.out.println(f.getFacultyNameType() + " факультет, средний балл по " +  SubjectNameType.MATH + " = " +
                        universityAction.averageScoreBySubjectInFaculty(f, new Subject(SubjectNameType.MATH)));
            } catch (SubjectException | StudentException | GroupException | FacultyException e) {
                e.printStackTrace();
            }
        });
        faculties.forEach(f ->
        {
            try {
                System.out.println(f.getFacultyNameType() + " факультет, средний балл по " +  SubjectNameType.INFORMATICS + " = " +
                        universityAction.averageScoreBySubjectInFaculty(f, new Subject(SubjectNameType.INFORMATICS)));
            } catch (SubjectException | StudentException | GroupException | FacultyException e) {
                e.printStackTrace();
            }
        });
        faculties.forEach(f ->
        {
            try {
                System.out.println(f.getFacultyNameType() + " факультет, средний балл по " +  SubjectNameType.PHYSICS + " = " +
                        universityAction.averageScoreBySubjectInFaculty(f, new Subject(SubjectNameType.PHYSICS)));
            } catch (SubjectException | StudentException | GroupException | FacultyException e) {
                e.printStackTrace();
            }
        });

//Средний балл по предмету для всего университета
        System.out.println("СРЕДНИЙ БАЛЛ ПО ПРЕДМЕТУ ДЛЯ ВСЕГО УНИВЕРСИТЕТА:");
        try {
            System.out.println("Средний балл университета по " +  SubjectNameType.MATH + " = " +
                    universityAction.averageScoreBySubjectInUniversity(new University(faculties), new Subject(SubjectNameType.MATH)));
        } catch (SubjectException | StudentException | GroupException | FacultyException | UniversityException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Средний балл университета по " +  SubjectNameType.INFORMATICS + " = " +
                    universityAction.averageScoreBySubjectInUniversity(new University(faculties), new Subject(SubjectNameType.INFORMATICS)));
        } catch (SubjectException | StudentException | GroupException | FacultyException | UniversityException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Средний балл университета по " +  SubjectNameType.PHYSICS + " = " +
                    universityAction.averageScoreBySubjectInUniversity(new University(faculties), new Subject(SubjectNameType.PHYSICS)));
        } catch (SubjectException | StudentException | GroupException | FacultyException | UniversityException e) {
            e.printStackTrace();
        }
    }
}
