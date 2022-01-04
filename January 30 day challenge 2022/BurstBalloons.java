import java.io.*;
import java.util.*;

public class BurstBalloons {
    private int[][] dp;
    private int get(int[] nums, int i){
        int n = nums.length;
        return i == -1 || i == n?1:nums[i];
    }
    private int getMaxCoins(int[] nums, int start, int end){
        if(end < start)
            return 0;
        if(dp[start][end] != 0)
            return dp[start][end];
        int coins = 0;
        for(int i = start; i <= end; i++){
            int coinsFromCurrBurst = get(nums, start-1)*get(nums, i)*get(nums, end+1);
            coinsFromCurrBurst = getMaxCoins(nums, start, i-1)+coinsFromCurrBurst+getMaxCoins(nums, i+1, end);
            coins = Math.max(coins, coinsFromCurrBurst);
        }
        dp[start][end] = coins;
        return coins;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        dp = new int[n][n];
        return getMaxCoins(nums, 0, n-1);
    }
}
