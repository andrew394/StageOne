package com.epam.learn.collection.optionaltask;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OptionalTask {

    private static final String FILE_PATH_READ = "src/main/resources/collection/data.txt";
    private static final String FILE_PATH_WRITE = "src/main/resources/collection/datareverse.txt";

    public static void main(String[] args) {
//1. Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.
        List<String> dataFileList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH_READ))) {
            //чтение построчно
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                dataFileList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.reverse(dataFileList);
        dataFileList.forEach(System.out::println);
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH_WRITE))) {
            for (String value : dataFileList) {
                bufferedWriter.write(value + "\n");
                bufferedWriter.flush();
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        System.out.println();

//4. Занести стихотворение в список. Провести сортировку по возрастанию длин строк.
        List<String> poemFileList = dataFileList;
        Collections.sort(poemFileList, Comparator.comparingInt(String::length));
        poemFileList.forEach(System.out::println);
    }
}
