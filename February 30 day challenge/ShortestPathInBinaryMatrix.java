import java.io.*;
import java.util.*;

public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]>queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        int cnt = 0, n = grid.length;
        int [][] directions = {{-1, -1}, {0, -1}, {1, -1}, {1, 0}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}};
        while(!queue.isEmpty()){
            int [] currPos = queue.poll();
            int x = currPos[0], y = currPos[1];
            if(grid[x][y] != 0)
                continue;
            cnt = currPos[2];
            if(x == n-1 && y == n-1)
                return cnt;
            grid[x][y] = -1;
            for(int [] direction : directions){
                int xi = x+direction[0], yi = y+direction[1];
                if(xi >= 0 && xi < n && yi >= 0 && yi < n && grid[xi][yi] == 0)
                    queue.add(new int[]{xi, yi, cnt+1});
            }
        }
        return -1;
    }
}
