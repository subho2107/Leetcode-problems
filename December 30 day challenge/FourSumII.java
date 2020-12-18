import java.io.*;
import java.util.*;

public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Long, Integer>ab = new HashMap<>();
        HashMap<Long, Integer>cd = new HashMap<>();
        int n = A.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                long sum = A[i]+B[j];
                ab.put(sum, ab.getOrDefault(sum, 0)+1);
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                long sum = C[i]+D[j];
                cd.put(sum, cd.getOrDefault(sum, 0)+1);
            }
        }
        int ans = 0;
        for(long sum : ab.keySet()){
            if(cd.containsKey(-sum))
                ans += ab.get(sum)*cd.get(-sum);
        }
        return ans;
    }
}
