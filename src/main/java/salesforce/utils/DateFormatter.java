/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Formats date.
 *
 * @author Juan Martinez.
 * @version 1.0 20 March 2020.
 */
public final class DateFormatter {
    private static SimpleDateFormat formatter = new SimpleDateFormat();
    private static Calendar calendar = Calendar.getInstance();
    private static final int DAYS = 0;
    private static final int MONTHS = 1;
    private static final int YEARS = 2;
    private static final String TODAY = "TODAY";
    private static final String BEFORE = "BEFORE";
    private static final String AFTER = "AFTER";
    private static final String REGEX = "[^0-9]+";
    private static final String EMPTY = "";
    private static final String FORMAT_API = "yyyy-MM-dd";
    private static final String FORMAT_UI = "M/dd/yyyy";
    private static String[] date;
    private static final int LIST_SIZE = 3;
    private static Date today = new Date(System.currentTimeMillis());

    /**
     * DateFormatter constructor.
     */
    private DateFormatter() {

    }

    /**
     * Allows to format today.
     *
     * @return date value.
     */
    private static String formatToday() {
        return formatter.format(today);
    }

    /**
     * Splits date value.
     *
     * @param dateString value.
     * @return a list of split date.
     */
    private static String[] spliter(final String dateString) {
        String splitDate = dateString;
        return splitDate.split("-");
    }

    /**
     * Replaces after date list.
     *
     * @param date list value.
     * @return a list.
     */
    private static int[] replaceStringsAfter(final String[] date) {
        int[] result = new int[LIST_SIZE];
        result[DAYS] = Integer.parseInt(date[DAYS].replaceAll(REGEX, EMPTY));
        result[MONTHS] = Integer.parseInt(date[MONTHS].replaceAll(REGEX, EMPTY));
        result[YEARS] = Integer.parseInt(date[YEARS].replaceAll(REGEX, EMPTY));
        return result;
    }

    /**
     * Replaces before string value.
     *
     * @param date list values.
     * @return a list.
     */
    private static int[] replaceStringsBefore(final String[] date) {
        int[] result = new int[LIST_SIZE];
        result[DAYS] = -Integer.parseInt(date[DAYS].replaceAll(REGEX, EMPTY));
        result[MONTHS] = -Integer.parseInt(date[MONTHS].replaceAll(REGEX, EMPTY));
        result[YEARS] = -Integer.parseInt(date[YEARS].replaceAll(REGEX, EMPTY));
        return result;
    }

    /**
     * Sets values to calendar.
     *
     * @param dateNumber value.
     * @return date.
     */
    private static Date setValuesToCalendar(final int[] dateNumber) {
        calendar.setTime(today);
        calendar.add(Calendar.DATE, dateNumber[DAYS]);
        calendar.add(Calendar.MONTH, dateNumber[MONTHS]);
        calendar.add(Calendar.YEAR, dateNumber[YEARS]);
        return calendar.getTime();
    }

    /**
     * Allows to format before today date.
     *
     * @param dateString value.
     * @return formatted data.
     */
    private static String before(final String dateString) {
        date = spliter(dateString);
        String[] dates = new String[LIST_SIZE];
        dates[DAYS] = date[DAYS];
        dates[MONTHS] = date[MONTHS];
        dates[YEARS] = date[YEARS];
        int[] dateNumber = replaceStringsBefore(dates);
        Date dateValue = setValuesToCalendar(dateNumber);
        return formatter.format(dateValue);
    }

    /**
     * Allows to format after today date.
     *
     * @param dateString value.
     * @return formatted date.
     */
    private static String after(final String dateString) {
        date = spliter(dateString);
        String[] dates = new String[LIST_SIZE];
        dates[DAYS] = date[DAYS];
        dates[MONTHS] = date[MONTHS];
        dates[YEARS] = date[YEARS];
        int[] dateNumber = replaceStringsAfter(dates);
        Date dateValue = setValuesToCalendar(dateNumber);
        return formatter.format(dateValue);
    }

    /**
     * Allows to format data.
     *
     * @param date value.
     * @return formatted date.
     */
    public static String formatDate(final String date) {
        formatter.applyPattern(FORMAT_API);
        String value = null;
        if (date == null) {
            return date;
        }
        if (date.equals(TODAY)) {
            value = formatToday();
        } else if (date.contains(BEFORE)) {
            value = before(date);
        } else if (date.contains(AFTER)) {
            value = after(date);
        }
        return value;
    }

    /**
     * Converts format date to format to use on UI.
     *
     * @param date value.
     * @return string value.
     */
    public static String formatDateUi(final String date) {
        String dateApi = formatDate(date);
        Date dateUi = null;
        try {
            dateUi = formatter.parse(dateApi);
            formatter.applyPattern(FORMAT_UI);
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        return formatter.format(dateUi);
    }
}
