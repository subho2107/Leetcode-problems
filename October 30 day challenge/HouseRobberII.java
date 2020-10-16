import java.io.*;
import java.util.*;

public class HouseRobberII {
    public int robNotCircular(int [] nums){
        int n = nums.length;
        int [] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[n-1];
    }
    public int rob(int[] nums) {
        int n= nums.length;
        if(n == 0)
            return 0;
        else if(n == 1)
            return nums[0];
        else if(n == 2)
            return Math.max(nums[0], nums[1]);
        else{
            int [] a = new int[n-1], b = new int[n-1];
            for(int i = 0; i < n-1; i++){
                a[i] = nums[i];
                b[i] = nums[i+1];
            }
            return Math.max(robNotCircular(a), robNotCircular(b));
        }
    }
}