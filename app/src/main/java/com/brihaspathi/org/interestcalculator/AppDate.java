package com.brihaspathi.org.interestcalculator;

import android.text.format.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class AppDate {

    public static final String MY_DATE = "MM/dd/yyyy";
    public static final String CUSTOM_DATE = "MMM d, yyyy";
    public static final String REQUEST_DATE = "yyyy-MM-dd";
    public static final String DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_TIME_WITH_T = "yyyy-MM-dd'T'HH:mm:ss";

    private Date date;

    /**
     * Constructs a AppDate with the specified date time format and
     * dateTime value.
     * A format is a String that describes date format.
     * And dateTime is a String that time value.
     *
     * @param format the date format
     * @param dateTime the date value string
     */
    public AppDate(String format, String dateTime) {
        try {
            parse(format, dateTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Constructs a AppDate with Date
     *
     * @param date Date type
     */
    public AppDate(Date date) {
        this.date = date;
    }

    /**
     * parse date with format
     *
     * @param format the date format
     * @param date the date value string
     */
    private void parse(String format, String date) {
        SimpleDateFormat sdfFormat = new SimpleDateFormat(format, Locale.getDefault());
        try {
            this.date = sdfFormat.parse(date);
        } catch (ParseException e) {
            String message = date + " format is not valid for " + format;
        }
    }

    /**
     * get time
     * */
    public String getTime() {
        return new SimpleDateFormat("h:mm a", Locale.getDefault()).format(date);
    }

    /**
     * get day
     * */
    public String getCalenderDay() {
        return new SimpleDateFormat("d", Locale.getDefault()).format(date);
    }

    /**
     * get month
     * */
    public String getMonth() {
        return new SimpleDateFormat("M", Locale.getDefault()).format(date);
    }

    /**
     * get year
     * */
    public String getYear() {
        return new SimpleDateFormat("yyyy", Locale.getDefault()).format(date);
    }

    /**
     * get month
     * */
    public String getCalenderMonth() {
        return new SimpleDateFormat("MMM", Locale.getDefault()).format(date);
    }

    /**
     * get Week day
     * */
    public String getCalenderWeek() {
        return new SimpleDateFormat("EEEE", Locale.getDefault()).format(date);
    }

    /**
     *  get date
     * */
    public String getCalenderDate() {
        return new SimpleDateFormat("MMM d, yyyy", Locale.getDefault()).format(date);
    }

    /**
     * get month and year
     * */
    public String getMonthAndYear() {
        return new SimpleDateFormat("MMMM yyyy", Locale.getDefault()).format(date);
    }

    /**
     *  get file name
     * */
    public String getFileNameDateFormat() {
        return new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(date);
    }

    /**
     * Get Date
     * */
    public Date getDate(){
        return date;
    }

    /**
     * get request date
     * */
    public String getRequestDate() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date);
    }

    /**
     * get Request date and time
     * */
    public String getRequestDateTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(date);
    }

    /**
     * @return complete Time in Relative Time span in String format
     */
    public String getTimeSpan(){
        long now = System.currentTimeMillis();

        return DateUtils.getRelativeTimeSpanString(
                date.getTime(),
                now,
                DateUtils.SECOND_IN_MILLIS).toString();
    }
}
