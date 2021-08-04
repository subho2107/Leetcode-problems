import java.io.*;
import java.util.*;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n-1; j++){
                int left = target-nums[i]-nums[j];
                int pos = Arrays.binarySearch(nums, j+1, n-1, left);
                int high = pos >= 0 ? pos : ~pos, low = high-1;
                if (high < n && Math.abs(left-nums[high]) < Math.abs(diff))
                    diff = left-nums[high];
                if (low > j && Math.abs(left - nums[low]) < Math.abs(diff))
                    diff = left-nums[low];
            }
        }
        return target-diff;
    }
}
