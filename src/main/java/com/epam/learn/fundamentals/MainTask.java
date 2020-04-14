package com.epam.learn.fundamentals;

import java.util.Scanner;

public class MainTask {

    public static void main(String[] args) {
//1. Приветствовать любого пользователя при вводе его имени через командную строку.
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scan.next();
        System.out.println("Hello, " + name);

//2. Отобразить в окне консоли аргументы командной строки в обратном порядке.
        char[] arrayName = name.toCharArray();
        for (int i = arrayName.length-1; i >= 0; i--) {
            System.out.print(arrayName[i]);
        }
        System.out.println();

//3. Вывести заданное количество случайных чисел с переходом и без перехода на новую строку
        int n = 5;   //количество случайных чисел
        int array[] = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*9);
        }
        for (int element : array) {
            System.out.println(element);
        }
        for (int element : array) {
            System.out.print(element);
        }
        System.out.println();

//4. Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на консоль.
        int sum = 0;
        int multiplic = 1;
        int a = 5;   //количество чисел
        int numberArray[] = new int[a];
        for (int i = 0; i < numberArray.length; i++) {
            System.out.println("Enter number: ");
            numberArray[i] = scan.nextInt();
        }
        for (int element : numberArray) {
            sum = sum + element;
            multiplic = multiplic * element;
        }
        System.out.println("sum = " + sum);
        System.out.println("multiplication = " + multiplic);

//5. Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.
        String month[] = {"January","February","March","April","May","June",
                "July","August","September","October","November","December"};
        System.out.println("Enter month number from 1 till 12: ");
        int m = scan.nextInt();   //номер месяца
        if (m >= 1 && m <= 12) {
            String choiceMonth = month[m - 1];
            System.out.println("Month: " + choiceMonth);
        } else {
            System.out.println("You entered incorrect month number.");
        }
        scan.close();
    }
}
