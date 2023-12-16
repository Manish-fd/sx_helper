package com.sx.sx_helper.helpers;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class SxHelper {

    public static long now() {
        return now("");
    }

    public static long now(String timeZone) {
        if (timeZone != null && !timeZone.isEmpty())
            return Calendar.getInstance(TimeZone.getTimeZone(ZoneId.of(timeZone))).getTime().getTime();
        return System.currentTimeMillis();
    }

    /**
     * format phone or twilio number
     *
     * @param number you want to format
     * @return formatted number String
     */
    public static String formatNumber(String number) {
        return formatNumber(number, false);
    }

    /**
     * format phone or twilio number
     *
     * @param number   you want to format
     * @param withPlus include '+' prefix or not
     * @return formatted number String
     */
    public static String formatNumber(String number, boolean withPlus) {
        if (number != null) {
            number = number.replace("+", "");
            number = number.replace(" ", "");
            number = number.replace("(", "");
            number = number.replace(")", "");
            return (withPlus ? "+" : "") + number;
        } else {
            return "";
        }
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

    public static String nullSafe(String s) {
        return s != null ? s : "";
    }

    public static int parseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static boolean isPhoneNumberValid(String s) {
        return Pattern.compile("^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$").matcher(nullSafe(s)).matches();
    }

    public static boolean isEmpty(String s) {
        return s == null || s.isEmpty() || s.equalsIgnoreCase("null");
    }

    public static boolean isNoEmpty(String s) {
        return !isEmpty(s);
    }

    public static <T> List<List<T>> chunks(List<T> source, int length) {
        if (length <= 0) throw new IllegalArgumentException("length = " + length);
        int size = source.size();
        if (size == 0) return new ArrayList<>();
        int fullChunks = (size - 1) / length;
        return IntStream.range(0, fullChunks + 1).mapToObj(n -> source.subList(n * length, n == fullChunks ? size : (n + 1) * length)).toList();
    }
}
