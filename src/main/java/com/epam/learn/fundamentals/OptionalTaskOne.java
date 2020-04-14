package com.epam.learn.fundamentals;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class OptionalTaskOne {

    public static void main(String[] args) {
// Ввести n чисел с консоли.
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter quantity array: ");
        int n = scan.nextInt();
        int numberInt[] = new int[n];
        for (int i = 0; i < numberInt.length; i++) {
            System.out.println("Enter number: ");
            numberInt[i] = scan.nextInt();
        }
        scan.close();

        String numberString[] = new String[numberInt.length];
        for (int i = 0; i < numberString.length; i++) {
            numberString[i] = Integer.valueOf(numberInt[i]).toString();
        }

//1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
        int minLength = numberString[0].length();
        int maxLength = numberString[0].length();
        String min = numberString[0];
        String max = numberString[0];
        for (String element : numberString) {
            System.out.println(element);
            if (element.length() < minLength) {
                minLength = element.length();
                min = element;
            }
            if (element.length() > maxLength) {
                maxLength = element.length();
                max = element;
            }
        }
        System.out.println("Самое короткое число = " + min + ", длина = " + minLength + "\n"
                + "Самое длинное число " + max + ", длина = " + maxLength);

//2. Вывести числа в порядке возрастания (убывания) значений их длины.
        String sortLength[] = new String[numberString.length];
        System.arraycopy(numberString, 0, sortLength, 0, numberString.length);
        for(int i = sortLength.length-1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if( sortLength[j].length() > sortLength[j+1].length() ){
                    String currentMax = sortLength[j];
                    sortLength[j] = sortLength[j+1];
                    sortLength[j+1] = currentMax;
                }
            }
        }
        System.out.println("Числа в порядке возрастания:");
        for(int i = 0; i < sortLength.length; i++){
            System.out.println(sortLength[i]);
        }
        System.out.println("Числа в порядке убывания:");
        for(int i = sortLength.length-1; i >= 0; i--){
            System.out.println(sortLength[i]);
        }

//3. Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.
        int sumLength = 0;
        double averageLength;
        for (String element : numberString) {
            sumLength += element.length();
        }
        averageLength = (double) sumLength/numberString.length;
        System.out.println("Числа, длина которых меньше средней длины:");
        for (String element : numberString) {
            if(element.length() < averageLength) {
                System.out.println("Число = " + element + ", длина = " + element.length());
            }
        }
        System.out.println("Числа, длина которых больше средней длины:");
        for (String element : numberString) {
            if(element.length() > averageLength) {
                System.out.println("Число = " + element + ", длина = " + element.length());
            }
        }

//4. Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.
        Set<Integer> number = new HashSet();
        int minDigit = numberInt[0];
        int c = minDigit;
        while (c > 0) {
            number.add(c % 10);
            c /= 10;
        }
        int minSize = (number.size() == 0) ? 1 : number.size();

        for (int i = 1; i < numberInt.length; i++) {
            Set<Integer> digit = new HashSet();
            int current = numberInt[i];
            while (current > 0) {
                digit.add(current % 10);
                current /= 10;
            }
            int currentSize = (digit.size() == 0) ? 1 : digit.size();
            if (currentSize < minSize) {
                minSize = currentSize;
                minDigit = numberInt[i];
            }
        }
        System.out.println("Число, в котором количество различных цифр минимально: " + minDigit);
    }

}
