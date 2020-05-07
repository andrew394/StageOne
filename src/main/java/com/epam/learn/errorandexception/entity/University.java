package com.epam.learn.errorandexception.entity;

import java.util.List;

public class University {

    private List<Faculty> faculties;

    public University(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }
}
