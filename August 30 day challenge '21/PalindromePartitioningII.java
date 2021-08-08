import java.io.*;
import java.util.*;

public class PalindromePartitioningII {
    public int minCut(String s) {
        int n = s.length();
        char [] arr = s.toCharArray();
        boolean [][] isPalin = new boolean[n][n];
        int [] dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = i;
            for(int j = i; j >= 0; j--){
                isPalin[j][i] = arr[i] == arr[j] && (i-j <= 1 || isPalin[j+1][i-1]);
                if(isPalin[j][i]){
                    dp[i] = j == 0? 0: Math.min(dp[i], dp[j-1]+1);
                }
            }
        }
        return dp[n-1];
    }
}
