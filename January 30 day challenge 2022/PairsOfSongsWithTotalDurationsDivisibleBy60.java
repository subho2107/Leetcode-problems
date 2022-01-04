import java.io.*;
import java.util.*;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        for (int t : time) {
            int theOther = (60 - t % 60) % 60;
            ans += count.getOrDefault(theOther, 0);
            count.put(t % 60, 1 + count.getOrDefault(t % 60, 0));
        }
        return ans;
    }
}
