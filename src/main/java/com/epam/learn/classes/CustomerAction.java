package com.epam.learn.classes;

import java.util.Arrays;
import java.util.Comparator;

public class CustomerAction {

    private Data data = new Data();

    public Customer[] sortBySurname() {
        Customer[] sortArray = data.dataCustomer();
        Arrays.sort(sortArray, Comparator.comparing(Customer::getSurname));
        return sortArray;
    }

    public Customer[] sortByName() {
        return Arrays.stream(data.dataCustomer()).
                sorted(Comparator.comparing(Customer::getName)).
                toArray(Customer[]::new);
    }

    public Customer[] filterCreditCardNumber(int cardNumberFrom, int cardNumberTo) {
        Customer[] filterArray = data.dataCustomer();
        filterArray = Arrays.stream(filterArray).
                filter(x -> x.getCreditCardNumber() > cardNumberFrom && x.getCreditCardNumber() < cardNumberTo).
                toArray(Customer[]::new);
        return filterArray;
    }
}
