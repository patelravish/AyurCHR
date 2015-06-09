package fv.ayurchr.commons.utils;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * User: RavishPatel
 * Date: 12/20/11
 * Time: 11:16 PM
 */
public class Utils {
    public static String getTime(Calendar cal) {
        String Time = "00:00";
        int min = getMinutes(cal);
        Time = getHour(cal) + ":";
        Time = Time + (min < 10 ? ("0" + min) : min) + " " + getAM_PM(cal);
        return Time;
    }

    public static int getHour(Calendar cal) {
        int hr = cal.get(Calendar.HOUR);
        return (hr == 0 ? 12 : hr);
    }

    public static int getMinutes(Calendar cal) {
        return cal.get(Calendar.MINUTE);
    }

    public static String getAM_PM(Calendar cal) {
        String AM_PM = "AM";
        if (cal.get(Calendar.AM_PM) == 1)
            AM_PM = "PM";
        return AM_PM;
    }

    public static String getWeekDay(Calendar cal) {
        int Day_No = cal.get(Calendar.DAY_OF_WEEK);
        String WeekDay = "Sunday";
        switch (Day_No) {
            case Calendar.SUNDAY: {
                WeekDay = "Sun";
                break;
            }
            case Calendar.MONDAY: {
                WeekDay = "Mon";
                break;
            }
            case Calendar.TUESDAY: {
                WeekDay = "Tue";
                break;
            }
            case Calendar.WEDNESDAY: {
                WeekDay = "Wed";
                break;
            }
            case Calendar.THURSDAY: {
                WeekDay = "Thu";
                break;
            }
            case Calendar.FRIDAY: {
                WeekDay = "Fri";
                break;
            }
            case Calendar.SATURDAY: {
                WeekDay = "Sat";
                break;
            }
        }
        return WeekDay;
    }

    public static String getDisplayDate(java.util.Date date) {
        String DisplayDate = "";
        Format DateFormatter;
        if (null == date) {
            date = new java.sql.Date(System.currentTimeMillis());
        }
        DateFormatter = new SimpleDateFormat("dd-MMM-yy hh:mm (E)");
        return DateFormatter.format(date);
    }

    public static String getDisplayDate(Calendar cal) {

        return getDisplayDate(cal.getTime());
    }
}
