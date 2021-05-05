package Codewars;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Suite2 {
    public static String game(long n) {
        double result = (n * n) / (double)2;
        Pattern pattern = Pattern.compile("\\.99999999999");

        //result is integer
        Matcher matcher = pattern.matcher(String.valueOf(result));
        if (matcher.find()) {
            return "[" + (long)Math.ceil(result) + "]";
        } else if ((result % 1) == 0 || result == 0.0) {
            return "[" + (long)result + "]";
        }

        return "[" + ((long)result * (long)(1 / (result - (long)result)) + 1) + ", " + (long)Math.ceil(1 / (result - (long)result)) + "]";
    }
}