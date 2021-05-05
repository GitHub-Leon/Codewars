package Codewars;

public class TenMinWalk {
    public static boolean isValid(char[] walk) {

        if (walk.length != 10) {
            return false;
        }

        int x = 0;
        int y = 0;

        for (int i = 0; i < walk.length; i++) {
            switch(walk[i]) {
                case 'n':
                    x++;
                    break;
                case 's':
                    x--;
                    break;
                case 'w':
                    y--;
                    break;
                case 'e':
                    y++;
                    break;
            }
        }

        if (x != 0 || y != 0) {
            return false;
        }

        return true;
    }
}
