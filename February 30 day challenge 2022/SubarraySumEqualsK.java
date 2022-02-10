import java.io.*;
import java.util.*;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer>map = new HashMap<>();
        int currSum = 0, n = nums.length, ans = 0;
        for(int i = 0; i < n; i++){
            currSum += nums[i];
            if(map.containsKey(currSum-k)){
                ans += map.get(currSum-k);
            }
            map.put(currSum, map.getOrDefault(currSum, 0)+1);
        }
        if(map.containsKey(k))
            ans += map.get(k);
        return ans;
    }
}
