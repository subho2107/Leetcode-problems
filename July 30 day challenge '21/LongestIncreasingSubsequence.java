import java.io.*;
import java.util.*;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
        int [] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = i-1; j>= 0; j--){
                if(arr[j] < arr[i] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
