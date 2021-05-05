package Codewars;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Arrays;

public class FindOutlier {
    ArrayList<Node> nodeList = new ArrayList<Node>();

    static int find(int[] integers) {
        int odd = 0;
        int even = 0;

        int maxIndex = 0;

        int[] lol = new int[] {1};
        int[] lol2 = Arrays.copyOf(lol, lol.length);
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] % 2 == 0) even++;
            else odd++;

            if (odd >= 1 && even >= 1) {
                maxIndex = i;
            }
        }

        for (int i = 0; i <= maxIndex; i++) {
            if (even > odd && (integers[i] % 2 == 1 || integers[i] % 2 == -1)) {
                return integers[i];
            } else if (odd > even && integers[i] % 2 == 0) {
                return integers[i];
            }
        }
        return 0;

    }
}