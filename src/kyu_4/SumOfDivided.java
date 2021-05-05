package Codewars;

import java.util.ArrayList;
import java.util.TreeMap;

public class SumOfDivided {
    public static String sumOfDivided(int[] l) {
        TreeMap<Integer, Integer> data = new TreeMap<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < l.length; i++) {
            int[] pf = primeFactor(l[i]);
            for (int k = 0; k < pf.length; k++) {
                if (!data.containsKey(pf[k])) {
                    int sum = 0;
                    for (int j = 0; j < l.length; j++) {
                        if (l[j] % pf[k] == 0) {
                            sum += l[j];
                        }
                    }
                    data.put(pf[k], sum);
                }
            }
        }

        for (var entry : data.entrySet()) {
            result.append("(").append(entry.getKey()).append(" ").append(entry.getValue()).append(")");
        }

        return result.toString();
    }

    public static int[] primeFactor(int num) {
        if (num < 0) num *= -1;

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 2; num != 1; i++) {
            if (isPrime(i)) {
                boolean added = false;
                while(num % i == 0) {
                    if (!added) result.add(i); added = true;
                    num /= i;
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private static boolean isPrime(int n) {
        boolean flag = false;
        for (int i = 2; i <= n/2; ++i) {
            if (n % i == 0) {
                flag = true;
                break;
            }
        }
        return !flag;
    }
}