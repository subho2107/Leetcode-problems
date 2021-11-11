import java.io.*;
import java.util.*;

public class MinimumValueToGetPositiveStepByStepSum {
    public int minStartValue(int[] nums) {
        int n = nums.length, sum = 0, minNeg = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            minNeg = Math.min(minNeg, sum);
        }
        return Math.abs(Math.min(0, minNeg))+1;
    }
}
