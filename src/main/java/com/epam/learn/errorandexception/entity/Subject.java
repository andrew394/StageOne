package com.epam.learn.errorandexception.entity;

public class Subject {

    private SubjectNameType subjectNameType;

    public Subject(SubjectNameType subjectNameType) {
        this.subjectNameType = subjectNameType;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectNameType=" + subjectNameType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        return subjectNameType == subject.subjectNameType;

    }

    @Override
    public int hashCode() {
        return subjectNameType != null ? subjectNameType.hashCode() : 0;
    }
}
