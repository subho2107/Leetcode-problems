import java.io.*;
import java.util.*;

public class MinimumMovesToEqualArrayElements2 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int num = nums[n/2];
        int ans = 0;
        for(int i : nums)
            ans += Math.abs(i - num);
        return ans;
    }
}
