import java.io.*;
import java.util.*;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        int longestSubstring = 0, n = s.length();
        int[] freq = new int[26];
        HashSet<Character>uniques = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniques.add(c);
        }
        int uniqueNums = uniques.size();
        for (int currUnique = 1; currUnique <= uniqueNums; currUnique++) {
            Arrays.fill(freq, 0);
            int start = 0, end = 0, uniqueChars = 0, countAtLeastK = 0;
            while (end < n){

                if (uniqueChars <= currUnique){
                    int pos = s.charAt(end)-'a';
                    if (freq[pos] == 0)uniqueChars++;
                    freq[pos]++;
                    if (freq[pos] == k)
                        countAtLeastK++;
                    end++;
                }
                else {
                    int pos = s.charAt(start)-'a';
                    if (freq[pos]== k)
                        countAtLeastK--;
                    freq[pos]--;
                    if (freq[pos] == 0)
                        uniqueChars--;
                    start++;
                }
                if (uniqueChars == currUnique && uniqueChars == countAtLeastK)
                    longestSubstring = Math.max(longestSubstring, end-start);
            }
        }
        return longestSubstring;
    }
}
