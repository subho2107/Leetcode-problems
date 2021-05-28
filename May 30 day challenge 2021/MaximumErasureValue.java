import java.io.*;
import java.util.*;

public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int [] prefSum = new int[n];
        prefSum[0] = nums[0];
        for(int i = 1; i < n; i++)
            prefSum[i] = prefSum[i-1]+nums[i];
        int ans = 0;
        HashMap<Integer, Integer>lastPos = new HashMap<>();
        int start = 0;
        for(int i = 0; i < n; i++){
            if(lastPos.containsKey(nums[i]) && lastPos.get(nums[i]) >= start){
                int currSum = prefSum[i-1];
                if(start - 1 >= 0) {
                    currSum -= prefSum[start-1];
                }
                start = lastPos.get(nums[i])+1;
                lastPos.put(nums[i], i);
                ans = Math.max(ans, currSum);
            }
            else
                lastPos.put(nums[i], i);
        }
        int currSum = prefSum[n-1];
        if(start - 1 >= 0)
            currSum -= prefSum[start-1];
        ans = Math.max(ans, currSum);
        return ans;
    }
}
