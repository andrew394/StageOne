package com.epam.learn.collection.maintask;

import com.epam.learn.collection.maintask.action.GemAction;
import com.epam.learn.collection.maintask.data.GemData;

import java.util.Scanner;

public class GemRunner {

    public static void main(String[] args) {

        GemAction gemAction = new GemAction();

        Scanner scan = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n" + "Консольное меню: " +
                    "\n" + "1. Иерархия драгоценных и полудрагоценных камней" +
                    "\n" + "2. Камни для ожерелья" +
                    "\n" + "3. Общий вес ожерелья (в каратах)" +
                    "\n" + "4. Общая стоимость ожерелья" +
                    "\n" + "5. Сортировка камней ожерелья на основе ценности" +
                    "\n" + "6. Камни в ожерелье, соответствующие прозрачности от 60% до 90%" +
                    "\n" + "0. Выход");

            System.out.println("\n" + "Выберите пункт меню: ");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    new GemData().dataGems().forEach(System.out::println);
                    break;
                case 2:
                    gemAction.createNecklace().forEach(System.out::println);
                    break;
                case 3:
                    System.out.println(gemAction.sumValueNecklace());
                    break;
                case 4:
                    System.out.println(gemAction.sumPriceNecklace());
                    break;
                case 5:
                    gemAction.sortNecklaceByPrice().forEach(System.out::println);
                    break;
                case 6:
                    gemAction.filterNecklaceByTransparence().forEach(System.out::println);
                    break;
                case 0:
                    break;
            }
        } while (choice!=0);

        scan.close();
    }
}
