package Codewars;

public class SudokuValidator {
    public static boolean check(int[][] sudoku) {

        //checks col and line
        for (int i = 0; i < sudoku.length; i++) {
            int sum = 0;

            for (int j = 0; j < sudoku[i].length; j++) {
                if (sudoku[i][j] == 0) return false;
                sum -= sudoku[j][i];
                sum += sudoku[i][j];
            }

            if (sum != 0) return false;
        }

        int[][] check = new int[9][2];
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++){
                check[sudoku[i][j]-1][1]++;
            }
            for (int j = 0; j < check.length; j++) {
                if (check[j][1] != 1) return false;
            }
            check = new int[9][2];
        }

        //checks cubes
        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                int sum = 0;
                sum += sudoku[i][j]   + sudoku[i][j+1]   + sudoku[i][j+2];
                sum += sudoku[i+1][j] + sudoku[i+1][j+1] + sudoku[i+1][j+2];
                sum += sudoku[i+2][j] + sudoku[i+2][j+1] + sudoku[i+2][j+2];

                if (sum != 45) return false;
            }
        }

        return true;
    }
}