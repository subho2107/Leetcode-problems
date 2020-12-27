import java.io.*;
import java.util.*;

public class DecodeWays {
    public int numDecodings(String s) {
        int [] dp = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            int num = Character.getNumericValue(s.charAt(i));
            if(num >= 1 && num <= 9)
            {
                if(i-1 >= 0)
                    dp[i] += dp[i-1];
                else
                    dp[i] = 1;
            }
            if(i >= 1){
                num = Integer.parseInt(s.substring(i-1, i+1));
                if(num >= 10 && num <= 26){
                    if(i-2 >= 0)
                        dp[i] += dp[i-2];
                    else
                        dp[i] += 1;
                }
            }
        }
        return dp[s.length()-1];
    }
}
