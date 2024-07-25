package com.coderscampus;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<SalesRecord> model3Sales = CsvReader.readSalesData("SalesData/src/model3.csv");
        List<SalesRecord> modelSSales = CsvReader.readSalesData("SalesData/src/modelS.csv");
        List<SalesRecord> modelXSales = CsvReader.readSalesData("SalesData/src/modelX.csv");

        SalesAnalysis.printYearlySalesReport(model3Sales, "Model 3");
        SalesAnalysis.printBestAndWorstMonths(model3Sales, "Model 3");

        SalesAnalysis.printYearlySalesReport(modelSSales, "Model S");
        SalesAnalysis.printBestAndWorstMonths(modelSSales, "Model S");

        SalesAnalysis.printYearlySalesReport(modelXSales, "Model X");
        SalesAnalysis.printBestAndWorstMonths(modelXSales, "Model X");

    }
}