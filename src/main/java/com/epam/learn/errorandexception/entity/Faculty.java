package com.epam.learn.errorandexception.entity;

import java.util.List;

public class Faculty {

    private FacultyNameType facultyNameType;
    private List<Group> groups;

    public Faculty(FacultyNameType facultyNameType, List<Group> groups) {
        this.facultyNameType = facultyNameType;
        this.groups = groups;
    }

    public Faculty(FacultyNameType technological, Group group) {
    }

    public FacultyNameType getFacultyNameType() {
        return facultyNameType;
    }

    public void setFacultyNameType(FacultyNameType facultyNameType) {
        this.facultyNameType = facultyNameType;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyNameType=" + facultyNameType +
                ", groups=" + groups +
                '}';
    }
}
