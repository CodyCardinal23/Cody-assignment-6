package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public static List<SalesRecord> readSalesData(String filePath) throws IOException {
        List<SalesRecord> salesRecords = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-yy");

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String headerLine = reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                YearMonth yearMonth = YearMonth.parse(values[0], formatter);
                LocalDate date = yearMonth.atDay(1);
                int sales = Integer.parseInt(values[1]);
                salesRecords.add(new SalesRecord(date, sales));
            }
        }
        return salesRecords;
    }
}