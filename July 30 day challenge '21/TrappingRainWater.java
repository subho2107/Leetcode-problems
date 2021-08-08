import java.io.*;
import java.util.*;

public class TrappingRainWater {
    public int trap(int[] height) {
        int ans = 0, prev = -1, n = height.length, maxHeight = height[n-1];
        int[]suffHeight = new int[n];
        for(int i = n-1; i >= 0; i--){
            suffHeight[i] = maxHeight;
            maxHeight = Math.max(maxHeight, height[i]);
        }
        for(int i = 0; i < n; i++){
            if(prev == -1 && height[i] == 0)
                continue;
            if(prev == -1 || height[i] >= height[prev] || suffHeight[i] <= height[i]){
                if(prev != -1 && !(height[i] >= height[prev]) && suffHeight[i] <= height[i]){
                    ans -= (i-prev-1)*(height[prev]-height[i]);
                }
                prev = i;
            }
            else{
                ans += height[prev]-height[i];
            }
        }
        return ans;
    }

}
