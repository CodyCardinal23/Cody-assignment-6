package com.coderscampus;

import java.time.LocalDate;

public class SalesRecord {
    private final LocalDate date;
    private final int sales;

    public SalesRecord(LocalDate date, int sales) {
        this.date = date;
        this.sales = sales;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getSales() {
        return sales;
    }

}
