package com.epam.learn.classes;

public class Data {

    private Customer arrayCustomer[] = {
            new Customer("Шевцов", "Андрей", "Александрович", "Sovetskaya 97", 19543782, 13869),
            new Customer("Карпов", "Александр", "Павлович", "Lenina 10", 98745456, 86435),
            new Customer("Помазун", "Павел", "Николаевич", "Kirova 25", 57646786, 26875),
            new Customer("Акинфеев", "Николай", "Сергеевич", "Kosareva 18", 75458768, 45876),
            new Customer("Ковалев", "Сергей", "Андреевич", "Mazurova 5", 25678534, 75357),
    };

    public Customer[] dataCustomer() {
        return arrayCustomer;
    }
}
