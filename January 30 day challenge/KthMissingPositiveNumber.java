import java.io.*;
import java.util.*;

public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        HashSet<Integer>set = new HashSet<>();
        for(int num : arr)
            set.add(num);
        int cnt = 0;
        int i;
        for(i = 1; cnt < k; i++){
            if(!set.contains(i))
                cnt++;
        }
        return i-1;
    }
}
