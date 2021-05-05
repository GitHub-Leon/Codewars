package Codewars;

import java.util.stream.IntStream;

public class Primes {
    public static IntStream stream() {
        return IntStream.rangeClosed(2, Integer.MAX_VALUE).filter(num -> isPrime(num));
    }

    public static boolean isPrime(int num) {
        if (num == 2) return true;  //2 is prime
        if (num % 2 == 0) return false;  //filters even nums out

        for (int i = 3; i < (int) Math.sqrt(num) + 1; i += 2)  //checks uneven nums
            if (num % i == 0) return false;

        return true;
    }
}