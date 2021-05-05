import java.io.*;
import java.util.*;

public class NonDecreasingArraySolution {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0, n = nums.length, pos = -1;;
        for(int i = 0; i < n-1; i++){
            if(nums[i] > nums[i+1])
            {
                int min = Math.min(nums[i], nums[i+1]), max = Math.max(nums[i], nums[i+1]);
                nums[i+1] = min;nums[i] = min;
                if((i-1 >= 0 && nums[i] < nums[i-1]) || (i+1 < n && nums[i] > nums[i+1]))
                {
                    nums[i] = max;
                    nums[i+1] = max;
                }

                break;
            }
        }
        for(int i = 0; i < n-1; i++)
            if(nums[i] > nums[i+1])
                return false;
        return true;
    }
}
