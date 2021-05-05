package Codewars;

import java.math.BigInteger;

public class Fibonacci2 {
    public static BigInteger fib(BigInteger num) {
        int n = num.intValue();
        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;

        if (n > 1) return power(MATRIX, n - 1)[0][0];
        if (n < 0) {
            n *= -1;
            if (n % 2 == 0) {
                return power(MATRIX, n - 1)[0][0].multiply(BigInteger.valueOf(-1));
            } else {
                return power(MATRIX, n - 1)[0][0];
            }
        }

        return BigInteger.valueOf(-1);
    }

    private static final BigInteger[][] MATRIX =
            {{BigInteger.ONE, BigInteger.ONE},
                    {BigInteger.ONE, BigInteger.ZERO}};


    private static BigInteger[][] power(BigInteger[][] m, int power) {
        if (power == 1) return m;
        BigInteger[][] sub = power(m, power / 2);
        if (power % 2 == 0) {
            return multiply(sub, sub);
        } else {
            return multiply(multiply(sub, sub), m);
        }
    }

    private static BigInteger[][] multiply(BigInteger[][] m1, BigInteger[][] m2) {
        return new BigInteger[][]{
                {m1[0][0].multiply(m2[0][0]).add(m1[0][1].multiply(m2[1][0])),
                 m1[0][0].multiply(m2[0][1]).add(m1[0][1].multiply(m2[1][1]))},
                {m1[1][0].multiply(m2[0][0]).add(m1[1][1].multiply(m2[1][0])),
                 m1[1][0].multiply(m2[0][1]).add(m1[1][1].multiply(m2[1][1]))}
        };
    }
}
