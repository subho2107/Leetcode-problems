import java.io.*;
import java.util.*;

public class LongestUncommonSubsequenceII {
    public void getSubsequence(String word, String subs, int currIndex, int pos, Set<String>[]subsqArr){
        if(currIndex == word.length())
        {
            subsqArr[pos].add(subs);
            return;
        }
        getSubsequence(word, subs, currIndex+1, pos, subsqArr);
        getSubsequence(word, subs+word.charAt(currIndex), currIndex+1, pos, subsqArr);
    }
    public int findLUSlength(String[] strs) {//brute force
        int n = strs.length;
        Set<String>[]subsq = new Set[n];
        for(int i = 0; i < n; i++){
            subsq[i] = new HashSet<>();
            getSubsequence(strs[i], "", 0, i, subsq);
        }
        int maxLength = -1;
        for(int i = 0; i < n; i++){
            for(String word : subsq[i])
            {
                boolean check = false;
                for(int j = 0; j < n; j++){
                    if(i == j)
                        continue;
                    if(subsq[j].contains(word)){
                        check = true;
                        break;
                    }
                }
                if(!check)
                    maxLength = Math.max(maxLength, word.length());
            }
        }
        return maxLength;
    }
}
