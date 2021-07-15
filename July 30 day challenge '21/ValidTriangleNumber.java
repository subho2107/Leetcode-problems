import java.io.*;
import java.util.*;

public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        if(n < 3)
            return 0;
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 2; i < n; i++){
            for (int lo = 0, hi = i-1; lo < hi; ) {
                if (nums[lo] + nums[hi] > nums[i]) {
                    ans += hi - lo;
                    hi--;
                } else {
                    lo++;
                }
            }
        }
        return ans;
    }
}
