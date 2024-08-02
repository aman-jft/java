package org.util.tbo;

import java.time.LocalDate;
import java.util.Calendar;

public class DateTest {
    public static void main(String[] args) {

//        LocalDate localDate = LocalDate.of(2024, 04, 1);
        LocalDate localDate = LocalDate.of(2024, 04, 30);
        System.out.println(localDate);
        int monthValue = localDate.getMonthValue();

        if (monthValue <= 3) {
            System.out.println("Financial Year : " + localDate.getYear());
        } else {
            System.out.println("Financial Year : " +(localDate.getYear()+1));
        }
    }
}
