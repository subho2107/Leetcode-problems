import java.io.*;
import java.util.*;

public class CherryPickupII {
    private int [][][] dp;
    private int[] directions = {-1, 0, 1};
    private int getCherries(int row, int col1, int col2, int [][] grid){
        int n = grid.length, m = grid[0].length;
        if(col1 >= m || col2 >= m || col1 < 0 || col2 < 0)
            return 0;
        if(dp[row][col1][col2] != -1)
            return dp[row][col1][col2];
        int fromCurrRow = grid[row][col1];
        if(col1 != col2)
            fromCurrRow += grid[row][col2];
        int maxCherriesStartingHere = 0;
        if(row < n-1){
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    int newCol1 = col1+directions[i], newCol2 = col2+directions[j];
                    maxCherriesStartingHere = Math.max(maxCherriesStartingHere, getCherries(row+1, newCol1, newCol2, grid));
                }
            }
        }
        maxCherriesStartingHere += fromCurrRow;
        return dp[row][col1][col2] = maxCherriesStartingHere;
    }
    public int cherryPickupTopDown(int[][] grid) {
        int m = grid[0].length, n = grid.length;
        dp = new int[n][m][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++)
                Arrays.fill(dp[i][j], -1);
        }
        getCherries(0, 0, m-1, grid);
        return dp[0][0][m-1];
    }
    public int cherryPickupBottomUp(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int [][][] dp = new int[n][m][m];
        for(int row = n-1; row >= 0; row--){
            for(int col1 = 0; col1 < m; col1++){
                for(int col2 = 0; col2 < m; col2++){
                    int curr = grid[row][col1];
                    if(col1 != col2)
                        curr += grid[row][col2];
                    int maxFromHere = 0;
                    if(row + 1 < n)
                    {
                        for(int i = 0; i < 3; i++){
                            for(int j = 0; j < 3; j++){
                                int newCol1 = col1+directions[i], newCol2 = col2+directions[j];
                                if(newCol1 < 0 || newCol2 < 0 || newCol1 >= m || newCol2 >= m)
                                    continue;
                                maxFromHere = Math.max(maxFromHere, dp[row+1][newCol1][newCol2]);
                            }
                        }
                    }
                    maxFromHere += curr;
                    dp[row][col1][col2] = maxFromHere;
                }
            }
        }
        return dp[0][0][m-1];
    }
}
