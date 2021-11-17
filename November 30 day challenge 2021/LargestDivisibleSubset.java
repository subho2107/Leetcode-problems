import java.io.*;
import java.util.*;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length, maxLength = 0, maxPos = -1;
        Arrays.sort(nums);
        int [][] dp = new int[n][2];//0 will have cnt and 1 will have position
        for(int i = 0; i < n; i++){
            dp[i][0] = 1;
            dp[i][1] = -1;
        }
        for(int i = 0; i < n; i++){
            for(int j = i-1; j >= 0; j--){
                if(nums[i] % nums[j] == 0 && dp[j][0] + 1 > dp[i][0]){
                    dp[i][0] = dp[j][0] + 1;
                    dp[i][1] = j;
                }
            }
            if(dp[i][0] > maxLength){
                maxLength = dp[i][0];
                maxPos = i;
            }
        }
        List<Integer>ans = new ArrayList<>();
        int pos = maxPos;
        while(pos >= 0){
            ans.add(nums[pos]);
            pos = dp[pos][1];
        }
        return ans;
    }

}
