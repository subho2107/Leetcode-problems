import java.io.*;
import java.util.*;

public class MaximumPerformanceOfATeam {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int [][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            arr[i][0] = speed[i];
            arr[i][1] = efficiency[i];
        }
        Arrays.sort(arr, (a, b) -> b[1] - a[1]);
        int MOD = (int) (1e9+7);
        long ans = 0;
        long sum = 0;
        PriorityQueue<Integer>heap = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for(int i = 0; i < n; i++){
            if(heap.size() >= k){
                int pop = heap.poll();
                sum -= pop;
            }
            heap.add(arr[i][0]);
            sum += arr[i][0];
            ans = Math.max(ans, sum*arr[i][1]);
        }
        return (int)(ans%MOD);
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
