import java.io.*;
import java.util.*;

public class MakingALargeIsland {
    int [][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int[][] getNeighbours(int row, int col){
        int[][] neighbours = new int[4][2];
        for(int i = 0; i < 4; i++){
            neighbours[i][0] = directions[i][0]+row;
            neighbours[i][1] = directions[i][1]+col;
        }
        return neighbours;
    }
    public int dfs(int row, int col, int index, int[][] grid){
        grid[row][col] = index;
        int n = grid.length, area = 0;
        for(int [] neighbour : getNeighbours(row, col)){
            int x = neighbour[0], y = neighbour[1];
            if(x < 0 || y < 0 || x>= n || y >= n || grid[x][y] != 1)
                continue;
            area += dfs(x, y, index, grid);
        }
        return area+1;
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int [] area = new int[n*n+2];
        int index = 2, ans = 0;
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == 1){
                    area[index] = dfs(row, col, index++, grid);
                }
            }
        }
        for(int i:area)
            ans = Math.max(ans, i);
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                Set<Integer>set = new HashSet<>();
                if(grid[row][col] == 0){
                    int temp = 1;
                    for(int [] neighbour : getNeighbours(row, col)){
                        int x = neighbour[0], y = neighbour[1];
                        if(x < 0 || y < 0 || x>= n || y >= n)
                            continue;
                        if(set.add(grid[x][y])){
                            temp += area[grid[x][y]];
                        }
                    }
                    ans = Math.max(ans, temp);
                }
            }
        }
        return ans;
    }
}