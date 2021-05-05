package Codewars;

import java.util.Arrays;

public class Kata {
    public static long nextBiggerNumber(long n) {

        String[] num = String.valueOf(n).split("");
        int[] arr = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            arr[i] = Integer.valueOf(num[i]);
        }

        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        int[] arrCopySorted = new int[arrCopy.length];
        Arrays.sort(arrCopy);
        for (int i = 0; i < arrCopy.length; i++) {
            arrCopySorted[i] = arrCopy[arrCopy.length - i - 1];
        }
        if (Arrays.equals(arrCopySorted, arr)) {
            return -1;
        }

        int j = arr.length-1;
        int k = arr.length-2;
        loop:
        while (true) {
            for (int i = j; i > k; i--) {
                for (int x = i; x > k; x--) {
                    if (arr[i] > arr[x]) {
                        int temp = arr[i];
                        arr[i] = arr[x];
                        arr[x] = temp;

                        if (arr.length-1 != x + 1) {
                            int[] nArr = new int[arr.length - (x + 1)];
                            for (int y = x + 1; y < arr.length; y++) {
                                nArr[y - (x + 1)] = arr[y];
                            }
                            Arrays.sort(nArr);
                            for (int y = x + 1; y < arr.length; y++) {
                                arr[y] = nArr[y - (x + 1)];
                            }
                        }
                        break loop;
                    }
                }
            }
            k--;
        }

        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result += String.valueOf(arr[i]);
        }

        return Long.parseLong(result);
    }
}