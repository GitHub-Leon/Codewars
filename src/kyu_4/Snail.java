package Codewars;

public class Snail {

    public static int[] snail(int[][] array) {
        if (array == null || array[0].length == 0) return new int[0];
        int[] sorted = new int[array.length * array.length];

        int pos = 0;
        int col = 0;
        while (col != array.length/2) {
            // first line add
            for (int j = col; j < array.length-col; j++) {
                sorted[pos++] = array[col][j];
            }

            // right line add
            for (int j = col+1; j < array.length-col; j++) {
                sorted[pos++] = array[j][array.length-col-1];
            }

            //bottom line add
            for (int j = col+1; j < array.length-col; j++) {
                sorted[pos++] = array[array.length-col-1][array.length-j-1];
            }

            //left line add
            for (int j = col+1; j < array.length-col-1; j++) {
                sorted[pos++] = array[array.length-j-1][col];
            }
            col++;
        }
        if (array.length % 2 != 0) sorted[pos] = array[array.length/2][array.length/2];

        return sorted;
    }
}
