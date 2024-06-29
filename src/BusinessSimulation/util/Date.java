package BusinessSimulation.util;

import java.util.Calendar;
import java.util.Comparator;

public class Date{
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public static Date currentDate() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return new Date(year, month, day);
    }

    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    public int compareTo(Date date) {
        if (currentDate().year != date.year) {
            return Integer.compare(currentDate().year, date.year);
        }
        if (currentDate().month != date.month) {
            return Integer.compare(currentDate().month, date.month);
        }
        return Integer.compare(currentDate().day, date.day);
    }
}

