import java.io.*;
import java.util.*;

public class MaxAreaOfIsland {
    int ans, currArea;
    public void dfs(int [][] grid, int row, int col){
        int n = grid.length, m = grid[0].length;
        if(row >= n || col >= m || row < 0 || col < 0 || grid[row][col] != 1)
            return;
        currArea++;
        grid[row][col] = -1;
        dfs(grid, row-1, col);
        dfs(grid, row+1, col);
        dfs(grid, row, col-1);
        dfs(grid, row, col+1);
    }
    public int maxAreaOfIsland(int[][] grid) {
        ans = 0;
        int n = grid.length, m = grid[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                currArea = 0;
                dfs(grid, i, j);
                ans = Math.max(ans, currArea);
            }
        }
        return ans;
    }
}
