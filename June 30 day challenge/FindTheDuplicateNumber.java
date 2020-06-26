import java.io.*;
import java.util.*;

public class FindTheDuplicateNumber {
    class Solution {
        public int findDuplicate(int[] nums) {
            Arrays.sort(nums);
            for(int pos = 0; pos < nums.length; pos++)
            {
                if(nums[pos] == nums[pos+1])
                    return nums[pos];
            }
            return 0;
        }
    }
}
