import java.io.*;
import java.util.*;

public class PartitionArrayIntoDisjointIntervals {
    public int partitionDisjoint(int[] arr) {
        int n = arr.length;
        int [] preMax = new int[n], suffMin = new int[n];
        int max = arr[0], min = arr[n-1];
        for(int i = 0; i < n ; i++){
            max = Math.max(max, arr[i]);
            preMax[i] = max;
        }
        for(int i = n-1; i >= 0; i--){
            min = Math.min(min, arr[i]);
            suffMin[i] = min;
        }
        for(int i = 0; i < n-1; i++){
            if(preMax[i] <= suffMin[i+1])
                return i+1;
        }
        return -1;
    }
}
