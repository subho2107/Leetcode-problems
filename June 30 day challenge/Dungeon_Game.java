import java.io.*;
import java.util.*;

public class Dungeon_Game {
    public int calculateMinimumHP(int[][] dungeon) {
        int rowLen = dungeon.length, colLen = dungeon[0].length;
        int [][] dp = new int[rowLen+1][colLen+1];
        for (int pos = 0; pos < rowLen + 1; pos++) {
            Arrays.fill(dp[pos], Integer.MAX_VALUE);
        }
        dp[rowLen][colLen-1] = 1;
        dp[rowLen-1][colLen] = 1;
        for (int rowPos = rowLen-1; rowPos >= 0; rowPos--)
        {
            for(int colPos = colLen-1; colPos >= 0; colPos--)
            {
                dp[rowPos][colPos] = Math.max(Math.min(dp[rowPos+1][colPos], dp[rowPos][colPos+1])-dungeon[rowPos][colPos], 1);
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int [][] dungeon = {{-2, -3, 3},{-5, -10, 1},{10, 30, -5}};
        sb.append(new Dungeon_Game().calculateMinimumHP(dungeon));
        System.out.println(sb);
    }
}
