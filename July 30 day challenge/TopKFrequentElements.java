import java.io.*;
import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for(int pos = 0; pos < nums.length; pos++)
        {
            frequency.put(nums[pos], frequency.getOrDefault(nums[pos], 0)+1);
        }
        ArrayList<Integer>uniqueNumbers = new ArrayList<>(frequency.keySet());
        uniqueNumbers.sort((a, b) -> {
            if (frequency.get(a) > frequency.get(b)) return -1;
            else if (frequency.get(a) == frequency.get(b))return 0;
            else return 1;
        });
        int [] arr = new int[k];
        for(int pos = 0; pos < k; pos++)
        {
            arr[pos] = uniqueNumbers.get(pos);
        }
        return arr;

    }
}
