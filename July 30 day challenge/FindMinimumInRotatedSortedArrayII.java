import java.io.*;
import java.util.*;

public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        for(int pos = 0; pos < nums.length-1; pos++){
            if(nums[pos] > nums[pos+1])
            {
                return nums[pos+1];
            }
        }
        return nums[0];
    }
}
