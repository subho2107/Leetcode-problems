import java.io.*;
import java.util.*;

public class LongestStringChain {
    public boolean isPredecessor(String a, String b) {//check if a is predecessor of b
        int n = a.length(), m = b.length();
        if (n != m - 1)
            return false;
        int i = 0, j = 0;
        int cnt = 0;
        while (i < n && j < m) {
            char chA = a.charAt(i), chB = b.charAt(j);
            if (chA == chB)
                i++;
            else
                cnt++;
            j++;
        }
        return cnt <= 1;
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (isPredecessor(words[j], words[i]))
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int ans = 0;
        for (int length : dp)
            ans = Math.max(ans, length);
        return ans;
    }
}
