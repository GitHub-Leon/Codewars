package Codewars;

import java.util.*;

public class Tour {

    public static int tour(String[] arrFriends, String[][] ftwns, Map<String, Double> h) {
        double totaldist = 0;
        double prevdist = 0;
        for (int a = 0; a < arrFriends.length; a++)
            for (String[] fTown : ftwns)
                if (fTown[0].equals(arrFriends[a])) {
                    double d = h.get(fTown[1]);
                    totaldist += Math.sqrt(Math.pow(d, 2) - Math.pow(prevdist, 2));
                    prevdist = d;
                }
        return (int) (totaldist + prevdist);
    }
}