import java.io.*;
import java.util.*;

public class KthSmallestNumberInMultiplicationTable {
    private boolean enough(int x, int m, int n, int k){
        int cnt = 0;
        for(int i = 1; i <= m; i++){
            cnt += Math.min(x/i, n);
        }
        return cnt >= k;
    }
    public int findKthNumber(int m, int n, int k) {
        int lo = 1, hi = m*n;
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            if(enough(mid, m, n, k))
                hi = mid;
            else
                lo = mid+1;
        }
        return lo;
    }
}
