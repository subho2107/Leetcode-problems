import java.io.*;
import java.util.*;

public class NumberOfMatchingSubsequences {
    public int numMatchingSubseq(String s, String[] words) {
        int n = s.length();
        int [][] nextPos = new int[n][26];
        int [] tempPos = new int[26];
        Arrays.fill(tempPos, -1);
        for(int i = n-1; i >= 0; i--){
            nextPos[i] = Arrays.copyOf(tempPos, 26);
            tempPos[s.charAt(i)-'a'] = i;
        }
        int cnt = 0;
        for(String word : words){
            int startPos = tempPos[word.charAt(0)-'a'];
            if(startPos == -1)
                continue;
            int j = -1;
            for(j = 1; j < word.length(); j++){
                int pos = nextPos[startPos][word.charAt(j)-'a'];
                if(pos == -1)
                    break;
                startPos = pos;
            }
            if(j == word.length())
                cnt++;
        }
        return cnt;
    }
}
