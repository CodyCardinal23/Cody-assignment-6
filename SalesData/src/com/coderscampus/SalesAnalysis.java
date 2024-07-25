package com.coderscampus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SalesAnalysis {

    public static void printYearlySalesReport(List<SalesRecord> salesRecords, String modelName) {
        System.out.println("\n" + modelName + " Yearly Sales Report");
        System.out.println("---------------------------");

        Map<Integer, Integer> yearlySales = salesRecords.stream()
                .collect(Collectors.groupingBy(
                        record -> record.getDate().getYear(),
                        Collectors.summingInt(SalesRecord::getSales)));

        yearlySales.forEach((year, sales) -> System.out.println(year + " -> " + sales));
         System.out.println();
    }

    public static void printBestAndWorstMonths(List<SalesRecord> salesRecords, String modelName) {
        Map<LocalDate, Integer> monthlySales = salesRecords.stream()
                .collect(Collectors.groupingBy(
                        record -> record.getDate().withDayOfMonth(1),
                        Collectors.summingInt(SalesRecord::getSales)));

        int bestSales = monthlySales.values().stream()
                .max(Integer::compare)
                .orElse(0);

        int worstSales = monthlySales.values().stream()
                .min(Integer::compare)
                .orElse(0);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");

        List<String> bestMonths = monthlySales.entrySet().stream()
                .filter(entry -> entry.getValue() == bestSales)
                .map(entry -> entry.getKey().format(formatter))
                .collect(Collectors.toList());

        List<String> worstMonths = monthlySales.entrySet().stream()
                .filter(entry -> entry.getValue() == worstSales)
                .map(entry -> entry.getKey().format(formatter))
                .collect(Collectors.toList());

        String bestMonthText = bestMonths.size() > 1 ? "months" : "month";
        String worstMonthText = worstMonths.size() > 1 ? "months" : "month";

        System.out.println("The best " + bestMonthText +
                " for " + modelName + " " + (bestMonths.size()
                > 1 ? "were: " : "was: ") + String.join(", ", bestMonths));
        System.out.println("The worst " + worstMonthText +
                " for " + modelName + " " + (worstMonths.size()
                > 1 ? "were: " : "was: ") + String.join(", ", worstMonths));
    }
}
