package Codewars;

public class PrimeDecomp {
    public static String factors(int n) {

        String format1 = "(%d**%d)";
        String format2 = "(%d)";
        StringBuilder retS = new StringBuilder();
        int[][] arr = new int[100][2];

        if (n % 2 != 0) {
            if(isPrime(n)) return "(" + n + ")";
        }


        for (int i = 3; i <= n; i+=2) {
            if (n % 2 == 0) {
                n /= 2;
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j][0] == 2) {
                        arr[j][1]++;
                        break;
                    }
                    if (arr[j][0] == 0) {
                        arr[j][0] = 2;
                        arr[j][1]++;
                        break;
                    }
                }
                i = 1;
            }
            else if (n % i == 0) {
                if (isPrime(i)) {
                    n /= i;
                    for (int j = 0; j < arr.length; j++) {
                        if (arr[j][0] == i) {
                            arr[j][1]++;
                            break;
                        }
                        if (arr[j][0] == 0) {
                            arr[j][0] = i;
                            arr[j][1]++;
                            break;
                        }
                    }
                    i = 1;
                }
            }
            if (n <= 1) break;
        }


        for (int i = 0; arr[i][0] != 0; i++) {
            if (arr[i][1] == 1) retS.append(String.format(format2, arr[i][0]));
            if (arr[i][1] > 1) retS.append(String.format(format1, arr[i][0], arr[i][1]));
        }

        return retS.toString();
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
