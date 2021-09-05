import java.io.*;
import java.util.*;

public class MaximumProfitInJobScheduling {
    class Job{
        int startTime, endTime, profit;
        Job(int start, int end, int cost){
            startTime = start;
            endTime = end;
            profit = cost;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[]jobs = new Job[n];
        for(int i = 0; i < n; i++){
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, (job1, job2) -> job1.endTime - job2.endTime);
        int [] dp = new int[n];
        dp[0] = jobs[0].profit;
        for(int i = 1; i < n; i++){
            int index = -1;
            for(int j = i-1; j >= 0; j--){
                if(jobs[j].endTime <= jobs[i].startTime){
                    index = j;
                    break;
                }
            }
            int currProfit = jobs[i].profit;
            if(index != -1)
                currProfit += dp[index];
            dp[i] = Math.max(dp[i-1], currProfit);
        }
        return dp[n-1];
    }
}
