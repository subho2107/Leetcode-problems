import java.io.*;
import java.util.*;

public class MinimumOperationsToMakeArrayEqual {
    public int minOperations(int n) {
        int [] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = n;
        int ans = 0;
        for(int i = n-1; i >= 0; i--){
            if(arr[i] <= 2*i+1)
                continue;
            ans += arr[i] - (2*i+1);
        }
        return ans;
    }
}
