package com.blackfat.java8;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/9/29-13:40
 */
public class DateTest {

    @Test
    public void localDate(){
        LocalDate date = LocalDate.of(2018, 9, 29);
        System.out.println(date.getYear());
        System.out.println(date.getMonthValue());
        System.out.println(date.getDayOfMonth());
    }

    @Test
    public void localTime(){
        LocalTime time = LocalTime.of(13, 47, 20);
        System.out.println(time.getHour());
        System.out.println(time.getMinute());
        System.out.println(time.getSecond());
    }

    @Test
    public void localDateTime(){
        LocalDate date = LocalDate.of(2018, 9, 29);
        LocalTime time = LocalTime.of(13, 47, 20);
        LocalDateTime dateTime = date.atTime(time);
        LocalDateTime timeDate = time.atDate(date);
        System.out.println(dateTime.equals(timeDate));
        System.out.println(Duration.between(dateTime,timeDate).isZero());
    }

    @Test
    public void DateTimeFormatter(){
        LocalDate date = LocalDate.of(2018, 9, 29);
        String dateFormatter = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(dateFormatter);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(date.format(formatter));
    }
}
