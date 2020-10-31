import java.io.*;
import java.util.*;

public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        int [] dp = new int[n];
        int [] cnts = new int[n];
        Arrays.fill(cnts, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    if (dp[j] >= dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnts[i] = cnts[j];
                    }
                    else if (dp[j] + 1 == dp[i])
                        cnts[i] += cnts[j];
                }
            }
        }
        int max = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > max){
                max = dp[i];
                cnt = 0;
            }
            if (dp[i] == max)
                cnt += cnts[i];
        }
        return cnt;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {

        }
        System.out.println(sb);
    }
}
