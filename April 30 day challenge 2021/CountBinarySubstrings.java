import java.io.*;
import java.util.*;

public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int n = s.length();
        int [] groupCnt = new int[n];
        int groupNo = 0;
        groupCnt[0] = 1;
        for(int i = 1; i < n; i++){
            if(s.charAt(i) != s.charAt(i-1))
                groupCnt[++groupNo] = 1;
            else
                groupCnt[groupNo]++;
        }
        int ans = 0;
        for(int i = 0; i < groupNo; i++){
            ans += Math.min(groupCnt[i], groupCnt[i+1]);
        }
        return ans;
    }
}
