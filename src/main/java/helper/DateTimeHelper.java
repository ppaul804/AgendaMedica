package helper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeHelper {

    public static java.sql.Date toDate(LocalDate localDate) {
        return java.sql.Date.valueOf(localDate);
    }

    public static java.sql.Time toTime(LocalTime localTime) {
        return java.sql.Time.valueOf(localTime);
    }

    public static LocalDate toLocalDate(java.sql.Date date) {
        return date.toLocalDate();
    }

    public static LocalTime toLocalTime(java.sql.Time time) {
        return time.toLocalTime();
    }

    public static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDateTime toLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

	public static String formatar(Date date) {
        return formatar(date, "dd/MM/yyyy");
	}

	public static String formatar(LocalDateTime localDateTime) {
        return formatar(localDateTime, "dd/MM/yyyy");
	}

	public static String formatar(Date date, String pattern) {
        LocalDateTime localDate = toLocalDateTime(date);
		return formatar(localDate, pattern);
	}

	public static String formatar(LocalDateTime localDateTime, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return localDateTime.format(formatter);
	}

    
}
