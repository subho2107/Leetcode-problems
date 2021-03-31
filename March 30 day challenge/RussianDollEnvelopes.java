import java.io.*;
import java.util.*;

class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] != o2[0])
                return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        int maxEnvelopes = 0;
        int n = envelopes.length;
        int [] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = i-1; j >= 0 ; j--) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }
        for (int num : dp)
            maxEnvelopes = Math.max(maxEnvelopes, num);
        return maxEnvelopes;
    }
    public static void main(String[] args) throws Exception {
        int [][] envelopes = {{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};
        System.out.println(new RussianDollEnvelopes().maxEnvelopes(envelopes));
    }
}
