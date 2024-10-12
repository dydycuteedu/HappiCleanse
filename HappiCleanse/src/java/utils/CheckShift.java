/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author truon
 */
public class CheckShift {
    
    private static final Set<String> holidays = new HashSet<>();
    
    static {
        holidays.add("2024-05-01");
        holidays.add("2024-04-30");
        holidays.add("2024-09-02");
        holidays.add("2024-12-25"); // Christmas
        holidays.add("2024-01-01"); // New Year
    }
    
    public static int checkHoliday(LocalDateTime shiftDate) {
        if (shiftDate.getDayOfWeek() == DayOfWeek.SATURDAY) {
            return 2;
        }
        if (shiftDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return 3;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String foramtterdDate = shiftDate.format(formatter);
        if (holidays.contains(foramtterdDate)) {
            return 4;
        }
        return 1;
    }
}
