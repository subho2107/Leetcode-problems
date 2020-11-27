import java.io.*;
import java.util.*;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        int longestSubstring = 0, n = s.length();
        int[] freq = new int[26];
        boolean check;
        for (int i = 0; i < n; i++) {
            Arrays.fill(freq, 0);
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;
                check = true;
                for (int num : freq) {
                    if (num == 0)
                        continue;
                    if (num < k) {
                        check = false;
                        break;
                    }
                }
                if (check)
                    longestSubstring = Math.max(longestSubstring, j - i + 1);
            }
        }
        return longestSubstring;
    }
}
