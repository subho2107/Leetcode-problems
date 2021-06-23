import java.io.*;
import java.util.*;

public class SwimInRisingWater {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]>pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        pq.add(new int[]{grid[0][0],0, 0});
        int n = grid.length, ans = grid[0][0];
        int [][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        grid[0][0] = 3000;
        while(true){
            int [] temp = pq.poll();
            int i = temp[1], j = temp[2];
            ans = Math.max(ans, temp[0]);
            if(i == n-1 && j == n-1)
                break;
            for(int []direction : directions){
                int tempi = i+direction[0], tempj = j+direction[1];
                if(tempi < 0 || tempj < 0 || tempi >= n || tempj >= n || grid[tempi][tempj] == 3000)
                    continue;
                pq.add(new int[]{grid[tempi][tempj], tempi, tempj});
                grid[tempi][tempj] = 3000;
            }
        }
        return ans;
    }
}
