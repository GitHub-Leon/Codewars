package Codewars;

import java.util.ArrayList;
import java.util.regex.Matcher;

class RevRot {

    public static String revRot(String strng, int sz) {
        if (sz <= 0 || strng.length() == 0) return "";

        ArrayList<String> chunks = new ArrayList<>();
        String result = "";

        for (int i = 0; i < strng.length()-sz; i += sz) {
            chunks.add(strng.substring(i, i+sz));
        }

        for (int i = 0; i < chunks.size() ; i++) {
            int sum = 0;

            for (int j = 0; j < chunks.get(i).length(); j++) {
                int lol = Integer.parseInt(String.valueOf(chunks.get(i).charAt(j)));
                sum += Math.pow(lol,2);
            }

            if (sum % 2 == 0) {
                for (int j = chunks.get(i).length()-1; j >= 0; j--) {
                    result += chunks.get(i).charAt(j);
                }
            } else {
                for (int j = 1; j < chunks.get(i).length(); j++) {
                    result += chunks.get(i).charAt(j);
                }
                result += chunks.get(i).charAt(0);
            }
        }

        return result;
    }
}