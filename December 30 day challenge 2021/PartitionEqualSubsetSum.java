import java.io.*;
import java.util.*;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length, halfSum;
        for(int num : nums)
            sum += num;
        if(sum % 2 == 1)
            return false;
        halfSum = sum/2;

        boolean [][] dp = new boolean[n][halfSum+1];
        for(int i = 0; i < n; i++)
            dp[i][0] = true;
        for(int i = 1; i <= halfSum; i++)
        {
            if(nums[0] == i)
                dp[0][i] = true;
            else
                dp[0][i] = false;
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j <= halfSum; j++){
                dp[i][j] = dp[i-1][j];
                if(j-nums[i] >= 0)
                    dp[i][j] |=  dp[i-1][j-nums[i]];
            }
        }
        return dp[n-1][halfSum];
    }
}
