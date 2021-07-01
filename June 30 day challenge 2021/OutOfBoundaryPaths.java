import java.io.*;
import java.util.*;

public class OutOfBoundaryPaths {
    int MOD = 1000_000_007;
    int [][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int dfs(int i, int j, int [][][] dp, int m, int n,int movesLeft){
        if(i >= m || j >= n || i < 0 || j < 0)
            return 1;
        if (movesLeft == 0)
            return 0;
        if (dp[i][j][movesLeft] >= 0)
            return dp[i][j][movesLeft];
        dp[i][j][movesLeft] = (dfs(i-1, j, dp, m, n , movesLeft-1)%MOD+dfs(i+1, j, dp, m, n, movesLeft-1)%MOD)%MOD+(dfs(i, j-1, dp, m , n, movesLeft-1)%MOD
        +dfs(i, j+1, dp, m, n, movesLeft-1)%MOD)%MOD;
        return dp[i][j][movesLeft];
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int [][][] dp = new int[m][n][maxMove+1];
        for (int[][] ints : dp) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, -1);
            }
        }
        dfs(startRow, startColumn, dp, m, n,maxMove);
        return dp[startRow][startColumn][maxMove];
    }
    public static void main(String[] args) throws Exception {
        System.out.println(new OutOfBoundaryPaths().findPaths(2,2,2,0,0));
    }
}
