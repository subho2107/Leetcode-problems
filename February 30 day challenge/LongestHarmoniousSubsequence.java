import java.io.*;
import java.util.*;

public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        TreeMap<Integer, Integer>hashMap = new TreeMap<>();
        for (int num : nums)
            hashMap.put(num, hashMap.getOrDefault(num, 0)+1);
        ArrayList<Integer>arrayList = new ArrayList<>(hashMap.keySet());
        int ans = 0;
        for (int i = 0; i < arrayList.size() - 1; i++) {
            int curr = arrayList.get(i), next = arrayList.get(i+1);
            if (curr+1 == next)
                ans = Math.max(ans, hashMap.get(curr)+hashMap.get(next));
        }
        return ans;
    }
}
