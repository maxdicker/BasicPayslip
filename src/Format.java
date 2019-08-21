import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public abstract class Format {

    public static LocalDate convertToDate (String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu", Locale.ENGLISH);
        return LocalDate.parse(date, formatter);
    }

    public static String convertToReadableDate (LocalDate date) {
        return date.getDayOfMonth() + " " + date.getMonth() + " " + date.getYear();
    }
}
