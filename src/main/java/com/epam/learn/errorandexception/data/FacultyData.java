package com.epam.learn.errorandexception.data;

import com.epam.learn.errorandexception.entity.Faculty;
import com.epam.learn.errorandexception.entity.FacultyNameType;
import com.epam.learn.errorandexception.entity.Group;

import java.util.Arrays;
import java.util.List;

public class FacultyData {

    private List<Group> groups = new GroupData().dataGroups();

    private List<Faculty> facultyList = Arrays.asList(
            new Faculty(FacultyNameType.TECHNOLOGICAL, Arrays.asList(groups.get(0), groups.get(1))),
            new Faculty(FacultyNameType.AUTOMATIONSYSTEMS, Arrays.asList(groups.get(2), groups.get(3))),
            new Faculty(FacultyNameType.ECONOMICS, Arrays.asList(groups.get(4), groups.get(5), groups.get(6))),
            new Faculty(FacultyNameType.POWERENGINEERING, Arrays.asList())
    );

    public List<Faculty> dataFaculties() {
        return facultyList;
    }
}
