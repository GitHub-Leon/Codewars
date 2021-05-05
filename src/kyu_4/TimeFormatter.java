package Codewars;

import java.util.LinkedHashMap;

public class TimeFormatter {

    public static String formatDuration(int seconds) {
        int yearVal, hourVal, secondVal, dayVal, minuteVal;
        String result = "";

        secondVal = seconds % 60;
        minuteVal = (seconds % 3600)/60;
        hourVal = (seconds % 86400)/3600;
        dayVal = (seconds % 31_536_000)/86400;
        yearVal = seconds/31_536_000;

        int[] values = new int[]{secondVal, minuteVal, hourVal, dayVal, yearVal};
        LinkedHashMap<String, Integer> pog = new LinkedHashMap<>();
        pog.put("second", secondVal);
        pog.put("minute", minuteVal);
        pog.put("hour", hourVal);
        pog.put("day", dayVal);
        pog.put("year", yearVal);

        int count = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] != 0) count++;
        }

        if (count == 0) return "now";
        if (count == 1) {
            for (int i = 0; i < values.length; i++) {
                if (values[i] != 0 && values[i] > 1) {
                    switch (i) {
                        case 0:
                            return values[i] + " seconds";
                        case 1:
                            return values[i] + " minutes";
                        case 2:
                            return values[i] + " hours";
                        case 3:
                            return values[i] + " days";
                        case 4:
                            return values[i] + " years";
                    }
                } else if (values[i] == 1) {
                    switch (i) {
                        case 0:
                            return values[i] + " second";
                        case 1:
                            return values[i] + " minute";
                        case 2:
                            return values[i] + " hour";
                        case 3:
                            return values[i] + " day";
                        case 4:
                            return values[i] + " year";
                    }
                }
            }
        }

        for (var lol: pog.entrySet()) {
            if (lol.getValue() == 1) {
                if (result.length() == 0) {
                    result = "and " + lol.getValue() + " " + lol.getKey();
                } else if (result.length() <= 20){
                    result = "" +  lol.getValue() + " " + lol.getKey() + " " + result;
                } else {
                    result = "" + lol.getValue() + " " + lol.getKey() + ", " + result;
                }
            }
            if (lol.getValue() > 1) {
                if (result.length() == 0) {
                    result = "and " + lol.getValue() + " " + lol.getKey() + "s";
                } else if (result.length() <= 20){
                    result = "" + lol.getValue() + " " + lol.getKey() + "s" + " " + result;
                } else {
                    result = "" + lol.getValue() + " " + lol.getKey() + "s" + ", " + result;
                }
            }
        }

        return result;
    }
}