import java.io.*;
import java.util.*;
public class MaximumGap {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if(n < 2)
            return 0;
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 0; i < n-1; i++){
            ans = Math.max(ans, nums[i+1] - nums[i]);
        }
        return ans;
    }
}
