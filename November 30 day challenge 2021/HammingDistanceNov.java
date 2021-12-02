import java.io.*;
import java.util.*;

public class HammingDistanceNov {
    public int hammingDistance(int x, int y) {
        int cnt = 0;
        while(x > 0 || y > 0){
            if(x % 2 != y % 2)
                cnt++;
            x /= 2;
            y /= 2;
        }
        return cnt;
    }
}