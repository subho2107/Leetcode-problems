import java.io.*;
import java.util.*;

public class MinimumOperationsToReduceXToZero {
    public int minOperations(int[] nums, int x) {
        HashMap<Integer, Integer>prevSum = new HashMap<>();
        int toSearchFor = 0, n = nums.length, sum = 0;
        for(int num : nums)
            toSearchFor += num;
        toSearchFor -= x;
        if(toSearchFor == 0)
            return n;
        int lengthOfSubarray = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            if(sum == toSearchFor)
                lengthOfSubarray = Math.max(lengthOfSubarray, i+1);
            if(prevSum.containsKey(sum-toSearchFor)){
                lengthOfSubarray = Math.max(lengthOfSubarray, i-prevSum.get(sum-toSearchFor));
            }
            prevSum.put(sum, i);
        }
        if(lengthOfSubarray == 0)
            return -1;
        int ans = n - lengthOfSubarray;
        return ans;

    }
}
