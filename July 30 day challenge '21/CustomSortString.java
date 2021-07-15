import java.io.*;
import java.util.*;

public class CustomSortString {
    public String customSortString(String order, String str) {
        int [] freq = new int[26];
        for(char ch : str.toCharArray())
            freq[ch - 'a']++;
        StringBuilder ans = new StringBuilder();
        for(char ch : order.toCharArray()){
            if(freq[ch - 'a'] == 0)
                continue;
            while(freq[ch - 'a']-- > 0)
                ans.append(ch);
        }
        for(int i = 0; i < 26; i++){
            if(freq[i] == 0)
                continue;
            while(freq[i]-- > 0)
                ans.append((char)(i+'a'));
        }
        return ans.toString();
    }
}
