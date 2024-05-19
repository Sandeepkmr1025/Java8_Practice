package com.sandeep.record.RecordsWithCollections;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> authors = List.of("Author1", "Author2", "Author3");
        Book book = new Book(1, authors);
        System.out.println(book);

    }
}
