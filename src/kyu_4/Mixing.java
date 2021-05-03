package kyu_4;

import java.util.HashMap;

public class Mixing {

    public static String mix(String s1, String s2) {
        HashMap<Character, Integer> occS1 = new HashMap<>();
        HashMap<Character, Integer> occS2 = new HashMap<>();
        int[][] topOcc = new int[30][3];
        String result = "";

        s1 = s1.replaceAll("[^(a-z)]*\\(*", "");
        s2 = s2.replaceAll("[^(a-z)]*\\(*", "");

        for (int i = 0; i < s1.length(); i++) {
            if (occS1.containsKey(s1.charAt(i))) {
                occS1.replace(s1.charAt(i), occS1.get(s1.charAt(i)) + 1);
            } else {
                occS1.put(s1.charAt(i), 1);
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            if (occS2.containsKey(s2.charAt(i))) {
                occS2.replace(s2.charAt(i), occS2.get(s2.charAt(i)) + 1);
            } else {
                occS2.put(s2.charAt(i), 1);
            }
        }


        for (var entry : occS1.entrySet()) {
            for (int j = 0; j < topOcc.length; j++) {
                if (topOcc[j][0] == 0) {
                    topOcc[j][0] = (int) entry.getKey();
                    topOcc[j][1] = entry.getValue();
                    topOcc[j][2] = 1;
                    break;
                }
            }
        }

        for (var entry : occS2.entrySet()) {
            for (int j = 0; j < topOcc.length; j++) {
                if (topOcc[j][0] == 0) {
                    topOcc[j][0] = (int) entry.getKey();
                    topOcc[j][1] = entry.getValue();
                    topOcc[j][2] = 2;
                    break;
                } else if (topOcc[j][0] == (int) entry.getKey()) {
                    if (topOcc[j][1] < entry.getValue()) {
                        topOcc[j][1] = entry.getValue();
                        topOcc[j][2] = 2;
                    } else if (topOcc[j][1] == entry.getValue()) {
                        topOcc[j][2] = 3;
                    }
                    break;
                }
            }
        }


        for (int i = 0; i < topOcc.length; i++) {
            int maxIndex = -1;
            int value = 0;
            int pos = Integer.MAX_VALUE;
            for (int j = 0; j < topOcc.length; j++) {
                if (topOcc[j][1] > value) {
                    value = topOcc[j][1];
                    maxIndex = j;
                    pos = topOcc[j][2];
                } else if (topOcc[j][1] == value) {
                    if (topOcc[j][2] < pos) {
                        value = topOcc[j][1];
                        maxIndex = j;
                        pos = topOcc[j][2];
                    }
                    if (topOcc[j][2] == pos && topOcc[j][0] < topOcc[maxIndex][0]) {
                        value = topOcc[j][1];
                        maxIndex = j;
                        pos = topOcc[j][2];
                    }
                }
            }
            topOcc[maxIndex][1] = 0;


            if (value <= 1) break;

            switch (topOcc[maxIndex][2]) {
                case 1:
                    result += 1 + ":";
                    break;
                case 2:
                    result += 2 + ":";
                    break;
                case 3:
                    result += "=:";
                    break;
            }

            for (int j = 0; j < value; j++) {
                result += (char)topOcc[maxIndex][0];
            }

            result += "/";
        }

        return result.length() == 0 ? "" : result.substring(0, result.length()-1);
    }
}
