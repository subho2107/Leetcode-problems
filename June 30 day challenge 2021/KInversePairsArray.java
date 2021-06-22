import java.io.*;
import java.util.*;

public class KInversePairsArray {
    public int kInversePairs(int n, int k) {
        int [] dp = new int[k+1];
        int MOD = 1000_000_007;
        for(int i = 1; i <= n; i++){
            int [] temp = new int[k+1];
            temp[0] = 1;
            for(int j = 1; j <= k; j++){
                int val = (dp[j] + MOD - (j-i >= 0? dp[j-i]:0))%MOD;
                temp[j] = (val + temp[j-1])%MOD;

            }
            dp = temp;
        }
        return ((dp[k] + MOD - (k > 0 ? dp[k - 1] : 0)) % MOD);
    }
}
