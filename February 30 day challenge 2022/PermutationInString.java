import java.io.*;
import java.util.*;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int [] freqS1 = new int[26], freqS2 = new int[26];
        int n1 = s1.length(), n2 = s2.length();
        if(n1 > n2)
            return false;
        for(int i = 0; i < n1; i++){
            freqS2[s2.charAt(i)-'a']++;
            freqS1[s1.charAt(i)-'a']++;
        }
        int cnt = 0;
        for(int i =0; i < 26; i++){
            if(freqS2[i] == freqS1[i])
                cnt++;
        }
        for(int start = 0, end = n1-1; end < n2; start++, end++){
            if(start > 0){
                int l = s2.charAt(start-1)-'a', r = s2.charAt(end)-'a';
                freqS2[l]--;
                if(freqS2[l] == freqS1[l])
                    cnt++;
                else if(freqS2[l] == freqS1[l]-1)
                    cnt--;
                freqS2[r]++;
                if(freqS2[r] == freqS1[r])
                    cnt++;
                else if(freqS2[r] == freqS1[r]+1)
                    cnt--;
            }
            if(cnt == 26)
                return true;
        }
        return false;
    }
}
