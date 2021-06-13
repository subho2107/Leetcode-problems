import java.io.*;
import java.util.*;

class MinimumNumberOfRefuelingStops {
    //dp approach
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        long [] dp = new long[n+1];
        dp[0] = startFuel;
        for(int i = 0; i < n; i++){
            for(int j = i; j >= 0; j--){
                if(dp[j] >= stations[i][0]){
                    dp[j+1] = Math.max(dp[j+1], dp[j]+stations[i][1]);
                }
            }
        }
        for(int i =0; i <= n; i++){
            if(dp[i] >= target)
                return i;
        }
        return -1;
    }
    //heap approach
    public int minRefuelStops2(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        PriorityQueue<Integer>queue = new PriorityQueue<>(Collections.reverseOrder());
        int ans = 0, prev = 0;
        for(int i = 0; i < n; i++){
            startFuel -= stations[i][0] - prev;
            while(!queue.isEmpty() && startFuel < 0){
                startFuel += queue.poll();
                ans++;
            }
            if(startFuel < 0)
                return -1;
            queue.add(stations[i][1]);
            prev = stations[i][0];
        }
        startFuel -= target-prev;
        while(!queue.isEmpty() && startFuel < 0){
            startFuel += queue.poll();
            ans++;
        }
        if(startFuel < 0)
            return -1;
        return ans;
    }

    public static void main(String[] args)throws Exception {
        int [][] stations = {{10,100}};
        int target = 100, startFuel = 1;
        System.out.println(new MinimumNumberOfRefuelingStops().minRefuelStops(target, startFuel, stations));
    }
}