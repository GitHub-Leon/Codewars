package Codewars;

public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        int hours = seconds/3600;
        int minute = (seconds-hours*3600)/60;
        int second = seconds-hours*3600-minute*60;

        String format = "%s:%s:%s";

        String hourStr;
        String minuteStr;
        String secondStr;

        if (hours == 0) hourStr = "00";
        else if (hours < 10) hourStr = "0" + hours;
        else hourStr = ""+hours;

        if (minute == 0) minuteStr = "00";
        else if (minute < 10) minuteStr = "0" + minute;
        else minuteStr = ""+minute;

        if (second == 0) secondStr = "00";
        else if (second < 10) secondStr = "0" + second;
        else secondStr = ""+second;


        return String.format(format, hourStr, minuteStr, secondStr);
    }
}
