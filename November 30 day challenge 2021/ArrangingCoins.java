import java.io.*;
import java.util.*;

public class ArrangingCoins {
    public int arrangeCoins(int n) {
        int low = 1, high = 1000_000, mid = 0;
        while(low <= high){
            mid = (low+high)/2;
            long sum = (long)mid*(mid+1)/2;
            if(sum == n)
                return mid;
            else if(sum < n)
                low = mid+1;
            else
                high = mid-1;
        }
        return high;
    }
}
