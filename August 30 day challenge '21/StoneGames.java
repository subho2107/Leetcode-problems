import java.io.*;
import java.util.*;

public class StoneGames {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n+2][n+2];
        for(int size = 1; size <= n; size++){
            for(int i = 0; i+size <=n ; i++){
                int j = i+size-1, currSign = 1;
                if((j-i)%2 == 1)
                    currSign = -1;
                dp[i+1][j+1] = Math.max(currSign*piles[i]+dp[i+2][j+1], currSign*piles[j]+dp[i+1][j]);
            }
        }
        return dp[1][n]> 0;
    }
}
