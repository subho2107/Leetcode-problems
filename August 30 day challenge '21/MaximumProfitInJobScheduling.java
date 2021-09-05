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
            int low = 0, high = i-1, index = -1;
            while (low <= high){
                int mid = (low+high)/2;
                if (jobs[mid].endTime <= jobs[i].startTime) {
                    low = mid+1;
                    index = mid;
                }
                else
                    high = mid-1;
            }
            int currProfit = jobs[i].profit;
            if(index != -1)
                currProfit += dp[index];
            dp[i] = Math.max(dp[i-1], currProfit);
        }
        return dp[n-1];
    }
}
