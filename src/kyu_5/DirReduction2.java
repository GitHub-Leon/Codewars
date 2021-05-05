package Codewars;

public class DirReduction2 {
    public static String[] dirReduc(String[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].equals("NORTH") && arr[i+1].equals("SOUTH")) {
                arr = remove(arr, i, i + 1);
                i = -1;
            } else if (arr[i].equals("SOUTH") && arr[i+1].equals("NORTH")) {
                arr = remove(arr, i, i + 1);
                i = -1;
            } else if (arr[i].equals("WEST") && arr[i+1].equals("EAST")) {
                arr = remove(arr, i, i + 1);
                i = -1;
            } else if (arr[i].equals("EAST") && arr[i+1].equals("WEST")) {
                arr = remove(arr, i, i + 1);
                i = -1;
            }
        }

        return arr;
    }

    private static String[] remove(String[] original, int start, int end) {
        String[] arr = new String[original.length-2];

        for (int i = 0, k = 0; i < original.length; i++) {
            if (i != start && i != end) {
                arr[k++] = original[i];
            }
        }

        return arr;
    }
}