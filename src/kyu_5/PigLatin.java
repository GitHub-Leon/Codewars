package Codewars;

public class PigLatin {
    public static String pigIt(String str) {
        String result = "";
        for (String word : str.split(" ")) {
            if (word.matches("([a-zA-Z])+")) {
                String newString = word.substring(1);
                newString += word.charAt(0);
                newString += "ay";

                if (result.length() == 0) {
                    result += newString;
                } else {
                    result += " " + newString;
                }
            } else {
                result += " " + word;
            }
        }

        return result;
    }
}