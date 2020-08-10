import java.io.*;
import java.util.*;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        Queue<int []>rottenPos = new LinkedList<>();
        int n = grid.length, m = grid[0].length, freshOrange = 0;
        for(int rowPos = 0; rowPos < n; rowPos++){
            for(int colPos = 0; colPos < m; colPos++){
                if(grid[rowPos][colPos]==2)
                    rottenPos.add(new int[]{rowPos, colPos});
                if(grid[rowPos][colPos]==1)
                    freshOrange++;

            }
        }
        int [][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int time = 0;
        while(!rottenPos.isEmpty() && freshOrange>0)
        {
            time++;
            int size = rottenPos.size();
            while (size-- > 0 ) {
                int[] coordinate = rottenPos.poll();
                for (int[] xy : directions) {
                    int x = coordinate[0] + xy[0];
                    int y = coordinate[1] + xy[1];
                    if (x < 0 || y < 0 || x > n - 1 || y > m - 1 || grid[x][y] == 0 || grid[x][y] == 2) continue;
                    rottenPos.add(new int[]{x, y});
                    grid[x][y] = 2;
                    freshOrange--;
                }
            }
        }
        if (freshOrange!=0)return -1;
        return time;
    }
    public static void main(String[] args){
        System.out.println(new RottingOranges().orangesRotting(new int[][]{{2,1,1}, {0, 1, 1}, {1,1,0}}));
    }
}
