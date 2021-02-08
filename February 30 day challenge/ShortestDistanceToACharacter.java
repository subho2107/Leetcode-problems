import java.io.*;
import java.util.*;

public class ShortestDistanceToACharacter {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int [] ans = new int[n];
        int [] prefix = new int[n], suffix = new int[n];
        int lastPos = -1;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == c)
                lastPos = i;
            prefix[i] = lastPos;
        }
        lastPos = -1;
        for(int i = n-1; i >= 0; i--){
            if(s.charAt(i) == c)
                lastPos = i;
            suffix[i] = lastPos;
        }
        for(int i = 0; i < n;i++){
            if(prefix[i] != -1 && suffix[i] != -1)
                ans[i] = Math.min(i - prefix[i], suffix[i] - i);
            else if(prefix[i] != -1)
                ans[i] = i - prefix[i];
            else
                ans[i] = suffix[i] - i;
        }
        return ans;
    }
}
