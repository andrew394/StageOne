package com.epam.learn.errorandexception.data;

import com.epam.learn.errorandexception.entity.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ScoreData {

     Map<Subject, List<Integer>> ivanovScore = Stream.of(new Object[][]{
        {new Subject(SubjectNameType.MATH), Arrays.asList(9,5,7,8,4,15)},
        {new Subject(SubjectNameType.INFORMATICS), Arrays.asList(4,10,8,6,9)},
        {new Subject(SubjectNameType.PHYSICS), Arrays.asList(8,5,7,9,4)},
    }).collect(Collectors.toMap(m -> (Subject) m[0], m -> (List<Integer>) m[1]));

    Map<Subject, List<Integer>> petrovScore = Stream.of(new Object[][]{
        {new Subject(SubjectNameType.MATH), Arrays.asList(5,7,8,5)},
        {new Subject(SubjectNameType.PHYSICS), Arrays.asList(7,9,4,10)},
    }).collect(Collectors.toMap(m -> (Subject) m[0], m -> (List<Integer>) m[1]));

    Map<Subject, List<Integer>> smirnovScore = Stream.of(new Object[][]{
        {new Subject(SubjectNameType.INFORMATICS), Arrays.asList(7,9,4,5)},
        {new Subject(SubjectNameType.PHYSICS), Arrays.asList(6,9,7,6)},
    }).collect(Collectors.toMap(m -> (Subject) m[0], m -> (List<Integer>) m[1]));

    Map<Subject, List<Integer>> alexandrovScore = Stream.of(new Object[][]{
    }).collect(Collectors.toMap(m -> (Subject) m[0], m -> (List<Integer>) m[1]));

    Map<Subject, List<Integer>> sokolovScore = Stream.of(new Object[][]{
        {new Subject(SubjectNameType.MATH), Arrays.asList(8,7,5,4)},
        {new Subject(SubjectNameType.INFORMATICS), Arrays.asList(6,9,4,7)},
        {new Subject(SubjectNameType.PHYSICS), Arrays.asList(9,6,8,5,10,4)},
    }).collect(Collectors.toMap(m -> (Subject) m[0], m -> (List<Integer>) m[1]));

    Map<Subject, List<Integer>> yakovlevScore = Stream.of(new Object[][]{
        {new Subject(SubjectNameType.MATH), Arrays.asList(5,7,10,1)},
        {new Subject(SubjectNameType.INFORMATICS), Arrays.asList(5,9,0,7)},
    }).collect(Collectors.toMap(m -> (Subject) m[0], m -> (List<Integer>) m[1]));

    Map<Subject, List<Integer>> morozovScore = Stream.of(new Object[][]{
        {new Subject(SubjectNameType.INFORMATICS), Arrays.asList(0,8,4,7)},
        {new Subject(SubjectNameType.PHYSICS), Arrays.asList(10,3,9,8,7)},
    }).collect(Collectors.toMap(m -> (Subject) m[0], m -> (List<Integer>) m[1]));

    Map<Subject, List<Integer>> novikovScore = Stream.of(new Object[][]{
        {new Subject(SubjectNameType.MATH), Arrays.asList(0,9,3,7)},
        {new Subject(SubjectNameType.INFORMATICS), Arrays.asList(8,3,6,5)},
        {new Subject(SubjectNameType.PHYSICS), Arrays.asList(4,9,6,8,10)},
    }).collect(Collectors.toMap(m -> (Subject) m[0], m -> (List<Integer>) m[1]));

    Map<Subject, List<Integer>> markovScore = Stream.of(new Object[][]{
        {new Subject(SubjectNameType.INFORMATICS), Arrays.asList(3,6,9,2,-4)},
        {new Subject(SubjectNameType.PHYSICS), Arrays.asList(1,9,0,4,8)},
    }).collect(Collectors.toMap(m -> (Subject) m[0], m -> (List<Integer>) m[1]));

    Map<Subject, List<Integer>> gerasimovScore = Stream.of(new Object[][]{
        {new Subject(SubjectNameType.MATH), Arrays.asList(1,9,0,4,6)},
        {new Subject(SubjectNameType.PHYSICS), Arrays.asList(7,3,5,1,9,2)},
    }).collect(Collectors.toMap(m -> (Subject) m[0], m -> (List<Integer>) m[1]));

    Map<Subject, List<Integer>> kozlovScore = Stream.of(new Object[][]{
        {new Subject(SubjectNameType.MATH), Arrays.asList(8,3,6,8)},
        {new Subject(SubjectNameType.INFORMATICS), Arrays.asList(9,3,6,2,9,6)},
        {new Subject(SubjectNameType.PHYSICS), Arrays.asList(10,7,4,9,4)},
    }).collect(Collectors.toMap(m -> (Subject) m[0], m -> (List<Integer>) m[1]));

    Map<Subject, List<Integer>> maximovScore = Stream.of(new Object[][]{
        {new Subject(SubjectNameType.MATH), Arrays.asList(10,5,8,4)},
        {new Subject(SubjectNameType.INFORMATICS), Arrays.asList(8,4,6,3,7)},
    }).collect(Collectors.toMap(m -> (Subject) m[0], m -> (List<Integer>) m[1]));

    Map<Subject, List<Integer>> andreevScore = Stream.of(new Object[][]{
        {new Subject(SubjectNameType.INFORMATICS), Arrays.asList(2,4,6,8)},
        {new Subject(SubjectNameType.PHYSICS), Arrays.asList(0,6,4,1,9)},
    }).collect(Collectors.toMap(m -> (Subject) m[0], m -> (List<Integer>) m[1]));

    Map<Subject, List<Integer>> vinogradovScore = Stream.of(new Object[][]{
        {new Subject(SubjectNameType.MATH), Arrays.asList(2,9,5,3,1,7)},
        {new Subject(SubjectNameType.INFORMATICS), Arrays.asList(2,5,8,9)},
        {new Subject(SubjectNameType.PHYSICS), Arrays.asList(1,3,10,7)},
    }).collect(Collectors.toMap(m -> (Subject) m[0], m -> (List<Integer>) m[1]));

    Map<Subject, List<Integer>> matveevScore = Stream.of(new Object[][]{
        {new Subject(SubjectNameType.MATH), Arrays.asList(5,7,6,8)},
        {new Subject(SubjectNameType.PHYSICS), Arrays.asList(2,3,7,8)},
    }).collect(Collectors.toMap(m -> (Subject) m[0], m -> (List<Integer>) m[1]));

    Map<Subject, List<Integer>> sergeevScore = Stream.of(new Object[][]{
        {new Subject(SubjectNameType.MATH), Arrays.asList(2,3,8,9)},
        {new Subject(SubjectNameType.INFORMATICS), Arrays.asList(3,5,7,6)},
    }).collect(Collectors.toMap(m -> (Subject) m[0], m -> (List<Integer>) m[1]));

    Map<Subject, List<Integer>> orlovScore = Stream.of(new Object[][]{
        {new Subject(SubjectNameType.MATH), Arrays.asList(4,7,5,2)},
        {new Subject(SubjectNameType.INFORMATICS), Arrays.asList(8,5,0,10)},
        {new Subject(SubjectNameType.PHYSICS), Arrays.asList(1,3,2,4)},
    }).collect(Collectors.toMap(m -> (Subject) m[0], m -> (List<Integer>) m[1]));

    Map<Subject, List<Integer>> timofeevScore = Stream.of(new Object[][]{
        {new Subject(SubjectNameType.INFORMATICS), Arrays.asList(2,3,7,8)},
        {new Subject(SubjectNameType.PHYSICS), Arrays.asList(9,10,7,6)},
    }).collect(Collectors.toMap(m -> (Subject) m[0], m -> (List<Integer>) m[1]));

    Map<Subject, List<Integer>> popovScore = Stream.of(new Object[][]{
        {new Subject(SubjectNameType.MATH), Arrays.asList(4,8,6,4)},
        {new Subject(SubjectNameType.PHYSICS), Arrays.asList(9,1,4,8)},
    }).collect(Collectors.toMap(m -> (Subject) m[0], m -> (List<Integer>) m[1]));
}
