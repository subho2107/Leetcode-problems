import java.io.*;
import java.util.*;

public class KInversePairsArray {
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n+1][k+1];
        dp[1][0] = 1;
        int MOD = 1000_000_007;
        for(int row = 1; row < n; row++){
            int maxK = (row*(row+1)/2)-row;
            for(int col = 0; col <= Math.min(k, maxK); col++)
            {
                for(int i = 0; i <= row && col+i <= k; i++){
                    dp[row+1][col+i] += dp[row][col];
                    dp[row+1][col+i] %= MOD;
                }
            }
        }
        return dp[n][k];
    }
}
