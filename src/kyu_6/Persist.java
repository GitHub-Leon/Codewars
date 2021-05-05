package Codewars;

class Persist {
    public static int persistence(long n) {
        if (n < 10) {
            return 0;
        }

        long result = 1;
        while (n != 0) {
            result *= n % 10;
            n /= 10;
        }

        return 1 + persistence(result);
    }
}
