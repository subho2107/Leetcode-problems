import java.io.*;
import java.util.*;

public class MaximumXorOfTwoNumbersInAnArray {
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for (int bit = 31; bit >= 0 ; bit--) {
            mask = mask|1<<bit;
            Set<Integer>eligibleNums = new HashSet<>();
            for (int num : nums)
                eligibleNums.add(mask&num);
            int temp = max|1<<bit;
            for (int pref : eligibleNums) {
                if (eligibleNums.contains(temp^pref)){
                    max = temp;
                    break;
                }
            }
        }
        return max;
    }
}
