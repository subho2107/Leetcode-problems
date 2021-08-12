import java.io.*;
import java.util.*;

public class ArrayOfDoubledPairs {
    public boolean canReorderDoubled(int[] arr) {
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for (int num : arr)
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        int cnt = 0;
        for (int num : freq.keySet()) {
            if (num != 0 && freq.getOrDefault(num * 2, 0) > 0 && freq.get(num) > 0) {
                int elements = Math.min(freq.get(num), freq.get(num * 2));
                freq.put(num, freq.get(num) - elements);
                freq.put(num * 2, freq.get(num * 2) - elements);
                cnt += elements;
            } else if (num == 0 && freq.get(num) > 1) {
                int elements = freq.get(num);
                freq.put(num, freq.get(num) - (elements / 2) * 2);
                cnt += elements / 2;
            }
        }
        return cnt == arr.length / 2;
    }

    public static void main(String[] args) {
        System.out.println(new ArrayOfDoubledPairs().canReorderDoubled(new int[]{10, 20, 40, 80}));
    }
}

