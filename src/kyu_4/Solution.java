package Codewars;

public class Solution{
    static int rectangleRotation(int a, int b) {
        int bigger = Math.max(a,b);
        int smaller = Math.min(a,b);

        double NE_x_y = Math.floor(Math.sqrt(bigger*bigger/(double)8));
        double width = 2 * NE_x_y + 1;
        double halfHeight = Math.floor(Math.sqrt(smaller * smaller/(double)8));
        double height = 2 * halfHeight + 1;

        double rec1 = width * height;
        double rec2;

        double hyp = Math.sqrt(2*NE_x_y*NE_x_y) + 1 / Math.sqrt(2);


        if (hyp <= bigger / (double)2) {
            rec2 = width + 1;
        } else {
            rec2 = width - 1;
        }

        double rec2h = 2* (Math.floor((smaller/(double)2 - 1/Math.sqrt(2)) / Math.sqrt(2)) + 1);
        return (int)(rec1 + rec2*rec2h);
    }
}