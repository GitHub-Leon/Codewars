package Codewars;

import java.util.Arrays;
import java.util.stream.Stream;

public class Rainfall {

    public static double mean(String town, String strng) {
        try {
            Double result =  Arrays.stream(strng.split("\n"))
                                .filter(s -> s.contains(town + ":"))
                                .map(s -> s.split("(,)?[a-zA-Z]+\\s"))
                                .flatMap(Stream::of)
                                .filter(s -> s.matches("\\d+.\\d"))
                                .mapToDouble(Double::parseDouble)
                                .average()
                                .getAsDouble();
            return result;
        } catch (Exception e) {
            return -1.0;
        }
    }

    public static double variance(String town, String strng) {
        Double avg = mean(town, strng);
        if (avg == -1.0) return -1.0;

        try {
            Double result = Arrays.stream(strng.split("\n"))
                    .filter(s -> s.contains(town))
                    .map(s -> s.split("(,)?[a-zA-Z]+\\s"))
                    .flatMap(Stream::of)
                    .filter(s -> s.matches("\\d+.\\d"))
                    .mapToDouble(Double::parseDouble)
                    .map(ax -> (ax - avg) * (ax - avg))
                    .average()
                    .getAsDouble();
            return result;
        } catch (Exception e) {
            return -1.0;
        }
    }
}
