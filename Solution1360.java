// Leetcode 1360: Number of Days Between Two Dates
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Solution1360 {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs((int)ChronoUnit.DAYS.between(LocalDate.parse(date1), LocalDate.parse(date2)));
    }
}