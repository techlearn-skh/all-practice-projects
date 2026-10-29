package com.skh;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        LocalDateTime date = LocalDate.of(2026, 11, 10).atStartOfDay();
        Date utilDate = Date.from(date.atZone(ZoneId.systemDefault()).toInstant());

        // Print the result
        System.out.println("Util Date: " + utilDate);
    }
}