import java.io.*;
import java.util.*;

public class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        int cnt = 0;
        HashMap<Integer, Integer>prevNums = new HashMap<>();
        for(int num : nums){
            if(prevNums.containsKey(k-num))
            {
                cnt++;
                prevNums.put(k-num, prevNums.get(k-num)-1);
                if(prevNums.get(k-num) == 0)
                    prevNums.remove(k-num);
            }
            else
                prevNums.put(num, prevNums.getOrDefault(num, 0)+1);
        }
        return cnt;
    }
}
