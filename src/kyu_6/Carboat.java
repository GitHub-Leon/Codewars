package Codewars;

public class Carboat {
    public static String howmuch(int m, int n) {

        StringBuilder result = new StringBuilder();
        result.append("[");

        int money = Math.min(m,n);

        while(money % 9 != 1) {
            money++;
        }

        for (int i = money; i <= Math.max(n, m); i+=9) {
            if (i % 7 == 2) result.append("[M: ").append(i).append(" B: ").append(Integer.valueOf(i / 7)).append(" C: ").append(Integer.valueOf(i / 9)).append("]");
        }

        return result.append("]").toString();
    }
}