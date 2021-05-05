package Codewars;

public class FindOdd {
    public static int findIt(int[] a) {
        int[][] nums = new int[a.length][2];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (a[i] == nums[j][0]) {
                    nums[j][1]++;
                    break;
                }
                if (nums[j][0] == 0) {
                    nums[j][0] = a[i];
                    nums[j][1]++;
                    break;
                }
            }
        }

        for (int i = 0; i < nums.length && nums[i][0] != 0; i++) {
            if (nums[i][1] % 2 == 1) return nums[i][0];
        }

        return -1;
    }
}