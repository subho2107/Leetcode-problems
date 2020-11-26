import java.io.*;
import java.util.*;

public class SmallestIntegerDivisibleByK {
    public int smallestRepunitDivByK(int k) {
        int N = 1, len = 1;
        HashSet<Integer>set = new HashSet<>();
        while(N % k != 0){
            len++;
            N = N * 10 + 1;
            N %= k;
            if(!set.add(N))
                return -1;
        }
        return len;
    }
}
