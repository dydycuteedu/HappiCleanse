/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class ConvertConstant {

    public static java.sql.Date convertLocalDateToDate(LocalDateTime localDate) {
        if (localDate == null) {
            return null;
        }
        return java.sql.Date.valueOf(localDate.toLocalDate());
    }

    public static LocalDateTime convertDateToLocalDate(java.sql.Date date) {
        if (date == null) {
            return null;
        }
        return LocalDateTime.of(date.toLocalDate(), LocalTime.MIDNIGHT);
    }

    public static LocalDateTime convertStringtoLocalDateTime(String dateTimeString) {
        // Định dạng chỉ lấy đến giờ và phút
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

        try {
            String test = dateTimeString.substring(0, 10).concat(" " + dateTimeString.substring(11));
            if (test.length() == 20) {
                test += "000";
            }
            if (test.length() == 21) {
                test += "00";
            }
            if (test.length() == 22) {
                test += "0";
            }
            // Parse chuỗi thành LocalDateTime chỉ với giờ và phút
            return LocalDateTime.parse(test, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format: " + e.getMessage());
            return null;
        }
    }

    public static LocalDateTime convertDateToLocalDateTime(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
