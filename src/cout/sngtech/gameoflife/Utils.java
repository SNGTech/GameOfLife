package cout.sngtech.gameoflife;

import java.util.Arrays;

public class Utils {

    public static int[][] copyOf(int[][] a) {
        int[][] copy = new int[a.length][a[0].length];
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                copy[i][j] = a[i][j];
            }
        }
        return copy;
    }
}
