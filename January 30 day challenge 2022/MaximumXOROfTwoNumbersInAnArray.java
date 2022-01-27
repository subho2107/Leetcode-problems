import java.io.*;
import java.util.*;

public class MaximumXOROfTwoNumbersInAnArray {
    public int findMaximumXOR(int[] nums) {
        int maxXOR = 0, mask = 0;
        for(int i = 31; i >= 0; i--){
            mask |= 1<<i;
            Set<Integer>prefix = new HashSet<>();
            for(int num : nums)
                prefix.add(num&mask);
            int temp = maxXOR|(1<<i);
            for(int prf : prefix){
                if(prefix.contains(temp^prf)){
                    maxXOR = temp;
                    break;
                }
            }
        }
        return maxXOR;
    }
}







