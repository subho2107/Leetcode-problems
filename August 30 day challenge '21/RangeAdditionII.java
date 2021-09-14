import java.io.*;
import java.util.*;

public class RangeAdditionII {
    public int maxCount(int m, int n, int[][] ops) {
        int minR = m, minC = n;
        for(int [] op : ops){
            int x = op[0], y = op[1];
            minR = Math.min(minR, x);
            minC = Math.min(minC, y);
        }
        return minR*minC;
    }
}
