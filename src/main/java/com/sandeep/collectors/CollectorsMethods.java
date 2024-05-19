package com.sandeep.collectors;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsMethods {
    public static void main(String[] args) {
        List<String> list = List.of("apple", "banana", "cherry", "date", "fig", "grape");

        IntSummaryStatistics stats = list.stream().collect(Collectors.summarizingInt(String::length));
        System.out.println("Average length: " + stats.getAverage());
        System.out.println("Max length: " + stats.getMax());
        System.out.println("Min length: " + stats.getMin());
        System.out.println("Sum length: " + stats.getSum());
        System.out.println("Count of elements: " + stats.getCount());

        Map<Boolean, List<String>> partitioned = list.stream().collect(Collectors.partitioningBy(s -> s.length() > 3));
        System.out.println(partitioned);
        System.out.println("Count of elements: " + (long) partitioned.get(true).size());
        System.out.println("Count of elements: " + (long) partitioned.get(false).size());

        //List<Integer> lengths = list.stream().collect(Collectors.mapping(String::length, Collectors.toList()));
        List<Integer> lengths = list.stream().map(String::length).collect(Collectors.toList());
        System.out.println(lengths);






    }
}
