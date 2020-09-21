import java.io.*;
import java.util.*;

public class UniquePathsIII {
    int cnt;

    public void recurse(int row, int col, int nonBlockedCnt, int[][] grid) {
        if (row < 0 || col < 0 || row > grid.length - 1 || col > grid[0].length - 1 || grid[row][col] < 0)
            return;
        if (grid[row][col] == 2 && nonBlockedCnt == 1) {
            cnt++;
            return;
        }
        nonBlockedCnt -= 1;
        int temp = grid[row][col];
        grid[row][col] = -1;
        this.recurse(row + 1, col, nonBlockedCnt, grid);
        this.recurse(row, col + 1, nonBlockedCnt, grid);
        this.recurse(row - 1, col, nonBlockedCnt, grid);
        this.recurse(row, col - 1, nonBlockedCnt, grid);
        grid[row][col] = temp;

    }

    public int uniquePathsIII(int[][] grid) {
        int nonBlockedCnt = 0, rStart = 0, cStart = 0;
        for (int rPos = 0; rPos < grid.length; rPos++) {
            for (int cPos = 0; cPos < grid[0].length; cPos++) {
                if (grid[rPos][cPos] == 1) {
                    rStart = rPos; cStart = cPos;
                }
                if (grid[rPos][cPos]>=0)
                    nonBlockedCnt++;
            }
        }
        this.recurse(rStart, cStart, nonBlockedCnt, grid);
        return this.cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                inp = buffer.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(inp[j]);
                }
            }
            System.out.println(new UniquePathsIII().uniquePathsIII(matrix));
        }
        System.out.println(sb);
    }
}
