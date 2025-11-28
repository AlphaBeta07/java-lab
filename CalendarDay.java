// CalendarDay.java
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class CalendarDay {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java CalendarDay <day> <month> <year>");
            return;
        }
        int d = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);
        LocalDate date = LocalDate.of(y, m, d);
        String dayName = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        System.out.println("The Day for given date is " + dayName);
    }
}
