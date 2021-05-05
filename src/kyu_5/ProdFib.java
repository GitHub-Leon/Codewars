package Codewars;

public class ProdFib {

    public static long[] productFib(long prod) {
        long result = 0;
        long fib1 = 0;
        long fib2 = 1;

        for (int i = 1; result != prod; i++) {
            long temp = fib1 + fib2;
            fib1 = fib2;
            fib2 = temp;

            result = fib1*fib2;

            if (result > prod) return new long[]{fib1, fib2, 0};
        }

        return new long[]{fib1, fib2, 1};
    }
}