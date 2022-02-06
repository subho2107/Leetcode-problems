import java.io.*;
import java.util.*;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer>prev = new HashMap<>();
        int sum = 0, n = nums.length, ans = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i] == 0?-1:1;
            if(prev.containsKey(sum))
                ans = Math.max(ans, i-prev.get(sum));
            else if(sum == 0)
                ans = Math.max(ans, i+1);
            else
                prev.put(sum, i);
        }
        return ans;
    }
}
