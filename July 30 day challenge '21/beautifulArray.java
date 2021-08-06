import java.io.*;
import java.util.*;

public class beautifulArray {
    public int[] beautifulArray(int n) {
        HashMap<Integer, int[]>map = new HashMap<>();
        return beautify(n, map);
    }
    public int[] beautify(int n, Map<Integer, int[]>map){
        if(map.containsKey(n))
            return map.get(n);
        int [] ans = new int[n];
        if(n == 1)
            ans[0] = 1;
        else{
            int i = 0;
            for(int num : beautify((n+1)/2, map))
                ans[i++] = num*2-1;
            for(int num : beautify(n/2, map))
                ans[i++] = num*2;
        }
        map.put(n, ans);
        return ans;
    }
}
