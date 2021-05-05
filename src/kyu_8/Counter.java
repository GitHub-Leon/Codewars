package Codewars;

import java.util.Arrays;

public class Counter {
    public static int countSheeps(Boolean[] arrayOfSheeps) {
        return (int) Arrays.stream(arrayOfSheeps).filter(i -> i).count();
    }
}
