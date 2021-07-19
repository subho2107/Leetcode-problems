import java.io.*;
import java.util.*;

public class CountVowelsPermutation {
    public int countVowelPermutation(int n) {
        int MOD = (int)(1e9+7);
        int [][] dp = new int[n][5];//'a'-> 0, 'e'-> 1, 'i'-> 2, 'o'-> 3, 'u'-> 4
        for(int i = 0; i < 5; i++)
            dp[0][i] = 1;
        for(int i = 1; i < n; i++){
            dp[i][0] = ((dp[i-1][1] + dp[i-1][2])%MOD + dp[i-1][4])%MOD;
            dp[i][1] = (dp[i-1][0]+dp[i-1][2])%MOD;
            dp[i][2] = (dp[i-1][1] + dp[i-1][3])%MOD;
            dp[i][3] = dp[i-1][2];
            dp[i][4] = (dp[i-1][2]+dp[i-1][3])%MOD;
        }
        int ans = 0;
        for(int num : dp[n-1])
        {
            ans += num;
            ans %= MOD;
        }
        return ans;
    }
}
