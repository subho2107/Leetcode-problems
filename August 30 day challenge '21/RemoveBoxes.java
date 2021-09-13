import java.io.*;
import java.util.*;

public class RemoveBoxes {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int [][][] dp = new int[n][n][n];
        return getMaxVal(boxes, 0, n-1, 0, dp);
    }
    public int getMaxVal(int [] boxes, int i, int j, int k, int [][][] dp){
        if(i > j)
            return 0;
        if(dp[i][j][k] > 0)
            return dp[i][j][k];
        int i0 = i, k0 = k;
        for(; i+1 <= j && boxes[i+1] == boxes[i]; k++, i++);
        int ans = (k+1)*(k+1)+getMaxVal(boxes, i+1, j, 0, dp);
        for(int m = i+1; m <= j; m++){
            if(boxes[m] == boxes[i]){
                ans = Math.max(ans, getMaxVal(boxes, i+1, m-1, 0, dp)+getMaxVal(boxes, m, j, k+1, dp));
            }
        }
        return dp[i0][j][k0] = ans;
    }
}
