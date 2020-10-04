import java.io.*;
import java.util.*;

public class KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer>map = new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num , 0)+1);
        }
        int cnt = 0;
        if(k > 0){
            for(int key :map.keySet()){
                if(map.containsKey(key+k))
                    cnt++;
            }
        }
        else{
            for(int key:map.keySet()){
                if(map.get(key)>1)
                    cnt++;
            }
        }
        return cnt;
    }
}
