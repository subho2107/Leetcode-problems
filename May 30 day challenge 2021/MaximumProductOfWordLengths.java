import java.io.*;
import java.util.*;

public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        int n = words.length;
        boolean [][] freq = new boolean[n][26];
        for(int i = 0; i < n; i++){
            for(char ch : words[i].toCharArray())
                freq[i][ch - 'a'] = true;
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                boolean check = true;
                for(int k = 0; k < 26; k++){
                    if(freq[i][k] && freq[j][k]){
                        check = false;
                        break;
                    }
                }
                if(check)
                    ans = Math.max(ans, words[i].length()*words[j].length());
            }
        }
        return ans;
    }
}
