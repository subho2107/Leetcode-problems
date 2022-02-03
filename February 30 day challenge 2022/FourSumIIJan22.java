import java.io.*;
import java.util.*;
public class FourSumIIJan22 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length, cnt = 0;
        HashMap<Integer, Integer>ab = new HashMap<>(), cd = new HashMap<>();
        for(int num : nums1){
            for (int num2 : nums2)
                ab.put(num+num2, ab.getOrDefault(num+num2, 0)+1);
        }
        for (int num : nums3) {
            for (int num2 : nums4) {
                if (ab.containsKey(-num-num2))
                    cnt += ab.get(-num-num2);
            }
        }
        return cnt;
    }
}
