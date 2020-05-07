package com.epam.learn.errorandexception.entity;

import java.util.List;

public class Group {

    private GroupNameType groupNameType;
    private List<Student> students;

    public Group(GroupNameType groupNameType, List<Student> students) {
        this.groupNameType = groupNameType;
        this.students = students;
    }

    public GroupNameType getGroupNameType() {
        return groupNameType;
    }

    public void setGroupNameType(GroupNameType groupNameType) {
        this.groupNameType = groupNameType;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupNameType=" + groupNameType +
                ", students=" + students +
                '}';
    }
}
