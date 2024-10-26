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
    
    public static java.sql.Date convertLocalDateToDate(LocalDateTime localDate){
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");

        try {
            // Parse the string into LocalDateTime using the formatter
            
            LocalDateTime a = LocalDateTime.parse(dateTimeString, formatter);
            System.out.println(a);
            return a;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format: " + e.getMessage());
            return null; // return null or handle the error as needed
        }
    }
    
    public static LocalDateTime convertDateToLocalDateTime(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
