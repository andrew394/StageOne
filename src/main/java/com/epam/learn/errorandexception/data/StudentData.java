package com.epam.learn.errorandexception.data;

import com.epam.learn.errorandexception.entity.Student;

import java.util.Arrays;
import java.util.List;

public class StudentData {

    private ScoreData scoreData = new ScoreData();

    private List<Student> studentList = Arrays.asList(
            new Student("Ivanov", scoreData.ivanovScore),
            new Student("Petrov", scoreData.petrovScore),
            new Student("Smirnov", scoreData.smirnovScore),
            new Student("Alexandrov", scoreData.alexandrovScore),
            new Student("Sokolov", scoreData.sokolovScore),
            new Student("Yakovlev", scoreData.yakovlevScore),
            new Student("Morozov", scoreData.morozovScore),
            new Student("Novikov", scoreData.novikovScore),
            new Student("Markov", scoreData.markovScore),
            new Student("Gerasimov", scoreData.gerasimovScore),
            new Student("Kozlov", scoreData.kozlovScore),
            new Student("Maximov", scoreData.maximovScore),
            new Student("Andreev", scoreData.andreevScore),
            new Student("Vinogradov", scoreData.vinogradovScore),
            new Student("Matveev", scoreData.matveevScore),
            new Student("Sergeevv", scoreData.sergeevScore),
            new Student("Orkov", scoreData.orlovScore),
            new Student("Timofeev", scoreData.timofeevScore),
            new Student("Popov", scoreData.popovScore)
    );

    public List<Student> dataStudents() {
        return studentList;
    }
}
