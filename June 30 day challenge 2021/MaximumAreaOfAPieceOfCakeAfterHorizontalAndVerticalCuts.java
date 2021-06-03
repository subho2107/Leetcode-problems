import java.io.*;
import java.util.*;

public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int MOD = (int) (1e9+7);
        int n = horizontalCuts.length, m = verticalCuts.length;
        long maxHeight = Math.max(horizontalCuts[0], h-horizontalCuts[n-1]);
        long maxWidth = Math.max(verticalCuts[0], w - verticalCuts[m-1]);
        for(int i = 0; i < n-1; i++)
            maxHeight = Math.max(maxHeight, horizontalCuts[i+1] - horizontalCuts[i]);
        for(int i = 0; i < m-1; i++)
            maxWidth = Math.max(maxWidth, verticalCuts[i+1] - verticalCuts[i]);
        int ans =(int) (maxHeight%MOD*maxWidth%MOD)%MOD;
        return ans;
    }
}
