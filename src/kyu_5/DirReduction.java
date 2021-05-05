package Codewars;

public class DirReduction {
    public static String[] dirReduc(String[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            boolean reduction = false;

            switch (arr[i]) {
                case "NORTH":
                    if (arr[i+1].equals("SOUTH")) reduction = true;
                    break;
                case "SOUTH":
                    if (arr[i+1].equals("NORTH")) reduction = true;
                    break;
                case "WEST":
                    if (arr[i+1].equals("EAST")) reduction = true;
                    break;
                case "EAST":
                    if (arr[i+1].equals("WEST")) reduction = true;
                    break;
            }

            if (reduction) {
                return dirReduc(remove(arr, i, i+1));
            }
        }

        return arr;
    }

    private static String[] remove(String[] original, int start, int end) {
        String[] arr = new String[original.length-2];

        for (int i = 0,k = 0; i < original.length; i++) {
            if (i != start && i != end) {
                arr[k++] = original[i];
            }
        }

        return arr;
    }
}
