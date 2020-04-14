package com.epam.learn.classes;

public class IdGenerator {
    private static long id = 0;
    private static final long MIN_VALUE = 0;
    private static final long MAX_VALUE = 100;

    private IdGenerator(){
    }

    public static long generateId(){
        if (id == MAX_VALUE){
            id = MIN_VALUE;
        }
        return ++id;
    }

}