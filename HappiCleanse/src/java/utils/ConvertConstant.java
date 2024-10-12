/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author truon
 */
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy'T'HH:mm:ss.SSSSS");

        try {
            // Parse the string into LocalDateTime using the formatter
            
            LocalDateTime a = LocalDateTime.parse(dateTimeString+"T00:00:00.00000", formatter);
            System.out.println(a);
            return a;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format: " + e.getMessage());
            return null; // return null or handle the error as needed
        }
    }
}
