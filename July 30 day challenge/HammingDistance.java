import java.io.*;
import java.util.*;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int cnt = 0;
        for(int pos = 0; pos < 31; pos++)
        {
            long pow = 1<<pos;
            if((pow&x)!=(pow&y))cnt++;
        }
        return cnt;
    }
}
