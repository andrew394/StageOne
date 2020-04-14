package com.epam.learn.classes;

import java.util.*;

/**
 * 2. Customer: id, Фамилия, Имя, Отчество, Адрес, Номер кредитной карточки, Номер банковского счета.
 *     Создать массив объектов. Вывести:
 *      a) список покупателей в алфавитном порядке;
 *      b) список покупателей, у которых номер кредитной карточки находится в заданном интервале.
 */
public class CustomerRunner {

    public static void main(String[] args) {
        CustomerAction customerAction = new CustomerAction();
        System.out.println("a) Список покупателей в алфавитном порядке по фамилии:");
        Arrays.stream(customerAction.sortBySurname()).forEach(System.out::println);
        System.out.println("Список покупателей в алфавитном порядке по имени:");
        System.out.println(Arrays.toString(customerAction.sortByName()));
        System.out.println("b) Список покупателей, у которых номер кредитной карточки находится в заданном интервале:");
        Arrays.stream(customerAction.filterCreditCardNumber(55555555, 99999999)).
                forEach(System.out::println);
    }
}
