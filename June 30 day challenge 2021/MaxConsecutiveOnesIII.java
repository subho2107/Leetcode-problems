import java.io.*;
import java.util.*;

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int [] prefix = new int[n], suffix = new int[n];
        int one = 0, startingPos = -1, ans = 0;
        for(int i = 0; i < n; i++){
            prefix[i] = one;
            if(nums[i] == 1)
                one++;
            else if(startingPos == -1)
                startingPos = i;
            if(nums[i] == 0)
                one = 0;
            ans = Math.max(ans, prefix[i]);
        }
        ans = Math.max(ans, one);
        if(k == 0)
            return ans;
        one = 0;
        for(int i = n-1; i >= 0; i--){
            suffix[i] = one;
            if(nums[i] == 1)
                one++;
            else
                one = 0;
        }
        HashMap<Integer, Integer>map = new HashMap<>();
        int zero = 0;
        for(int i = startingPos; i < n; i++){
            if(nums[i] != 0)
                continue;
            zero++;
            map.put(zero, i);
            int zeroesToFlip = Math.min(k, zero);
            int pos = map.get(zero-zeroesToFlip+1);
            int pos2 = i;
            int totalOnes = pos2-pos+1+prefix[pos]+suffix[pos2];
            ans = Math.max(ans, totalOnes);
        }
        return ans;
    }
}
