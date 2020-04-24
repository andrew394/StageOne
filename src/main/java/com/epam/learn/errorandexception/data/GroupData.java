package com.epam.learn.errorandexception.data;

import com.epam.learn.errorandexception.entity.Group;
import com.epam.learn.errorandexception.entity.GroupNameType;
import com.epam.learn.errorandexception.entity.Student;

import java.util.Arrays;
import java.util.List;

public class GroupData {

    private List<Student> students = new StudentData().dataStudents();

    private List<Group> groupList = Arrays.asList(
            new Group(GroupNameType.TA31, Arrays.asList(students.get(0), students.get(1), students.get(2), students.get(3))),
            new Group(GroupNameType.TA41, Arrays.asList(students.get(4), students.get(5), students.get(6))),
            new Group(GroupNameType.AA11, Arrays.asList(students.get(7), students.get(8), students.get(9))),
            new Group(GroupNameType.AA21, Arrays.asList(students.get(10), students.get(11), students.get(12))),
            new Group(GroupNameType.EA31, Arrays.asList(students.get(13), students.get(14), students.get(15))),
            new Group(GroupNameType.EA41, Arrays.asList(students.get(16), students.get(17), students.get(18))),
            new Group(GroupNameType.EA444, Arrays.asList())
    );

    public List<Group> dataGroups() {
        return groupList;
    }
}
