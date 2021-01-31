import java.io.*;
import java.util.*;

public class MinimizeDeviationInArray {
    public int minimumDeviation(int[] nums) {
        int n = nums.length;
        TreeSet<Integer>set = new TreeSet<>();
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n ; i++){
            if(nums[i] % 2 == 1)
                nums[i] *= 2;
        }
        for(int num : nums)
            set.add(num);
        while(true){
            int min = set.first();
            int max = set.last();
            ans = Math.min(ans, max - min);
            if(max % 2 == 0){
                set.remove(max);
                set.add(max/2);
            }
            else
                return ans;
        }
    }
}
