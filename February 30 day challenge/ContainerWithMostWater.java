import java.io.*;
import java.util.*;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int n = height.length;
        int ans = 0, left = 0, right = n-1;
        while(left < right){
            int minHeight = Math.min(height[left], height[right]);
            ans = Math.max(ans, (right - left)*minHeight);
            if(height[left] == minHeight)
                left++;
            else right--;
        }
        return ans;
    }
}
