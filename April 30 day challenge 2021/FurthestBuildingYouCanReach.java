import java.io.*;
import java.util.*;

public class FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer>heightGaps = new PriorityQueue<>();
        int i;
        for(i = 0; i <  n-1 && ladders > 0; i++){
            int gap = heights[i+1] - heights[i];
            if(gap <= 0)
                continue;
            heightGaps.add(gap);
            ladders--;
        }
        for(;i < n-1; i++){
            int gap = heights[i+1] - heights[i];
            if(gap <= 0)
                continue;
            int currBricksNeeded = gap;
            if(!heightGaps.isEmpty()){
                currBricksNeeded = Math.min(currBricksNeeded, heightGaps.poll());
            }
            if(bricks < currBricksNeeded)
                return i;
            bricks -= currBricksNeeded;
        }
        while(i < n-1 && heights[i] >= heights[i+1])
            i++;
        return i;
    }
}
