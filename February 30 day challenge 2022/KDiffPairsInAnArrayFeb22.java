import java.util.*;

public class KDiffPairsInAnArrayFeb22 {
    public int findPairs(int[] nums, int k) {
        int cnt = 0;
        Map<Integer, Integer>map = new HashMap<>();
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0)+1);
        for(int key : map.keySet()){
            if((k != 0 && map.containsKey(key+k)) || (k == 0 && map.get(key) > 1))
                cnt++;
        }
        return cnt;
    }
}
