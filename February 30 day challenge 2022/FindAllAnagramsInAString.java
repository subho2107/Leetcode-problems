import java.io.*;
import java.util.*;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        int [] freqOfS = new int[26], freqOfP = new int[26];
        int n = s.length(), m = p.length();
        List<Integer>ans = new ArrayList<>();
        if(m > n)
            return ans;
        for(char ch : p.toCharArray())
            freqOfP[ch-'a']++;
        for(int i = 0; i < m; i++)
            freqOfS[s.charAt(i)-'a']++;
        for(int i = m-1, j = 0; i < n; i++, j++){
            boolean check = true;
            for(int k = 0; k < 26; k++){
                if(freqOfS[k] != freqOfP[k]){
                    check = false;
                    break;
                }
            }
            if(check)
                ans.add(j);
            freqOfS[s.charAt(j)-'a']--;
            if(i+1 < n)
                freqOfS[s.charAt(i+1)-'a']++;
        }
        return ans;
    }
}
