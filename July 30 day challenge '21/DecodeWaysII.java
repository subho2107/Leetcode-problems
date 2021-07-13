import java.io.*;
import java.util.*;

public class DecodeWaysII {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0')
            return 0;
        int MOD = (int)(1e9+7);
        char [] arr = s.toCharArray();
        int n = s.length();
        long [] dp = new long[n];
        dp[0] = 1;
        if(arr[0] == '*')
            dp[0] = 9;
        for(int i = 1; i < n; i++){
            long temp = 1;
            if(i - 2 >= 0)
                temp = dp[i-2];

            if(arr[i] == '*'){
                dp[i] += (9*dp[i-1])%MOD;
                dp[i]%=MOD;
                if(arr[i-1] == '1')
                    dp[i] += (9*temp)%MOD;
                else if(arr[i-1] == '2')
                    dp[i] += (6*temp)%MOD;
                else if(arr[i-1] ==  '*')
                    dp[i] += (15*temp)%MOD;
            }
            else{
                if(arr[i] != '0')
                    dp[i] += dp[i-1];
                dp[i]%=MOD;
                if(arr[i-1] == '*'){
                    if(arr[i] >= '0' && arr[i] <= '6')
                        dp[i] += (2*temp)%MOD;
                    else
                        dp[i] += temp;
                }
                else{
                    if((arr[i-1] == '1') || (arr[i-1] == '2' && arr[i] >= '0' && arr[i] <= '6'))
                        dp[i] += temp;
                }
            }
            dp[i]%=MOD;
        }
        return (int)(dp[n-1]%MOD);
    }
}
