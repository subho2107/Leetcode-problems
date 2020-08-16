import java.io.*;
import java.util.*;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n==0)
            return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]>o2[1])
                    return 1;
                else if (o1[1]<o2[1])
                    return -1;
                else return 0;
            }
        });
        int cnt = 1, r1 = intervals[0][1];
        for (int pos = 1; pos < n; pos++) {
            int l1 = intervals[pos][0];
            int r2 = intervals[pos][1];
            if (l1 >= r1) {
//                System.out.println(l1+" "+r2);
                r1 = r2;
                cnt++;
            }
        }
        return n-cnt;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int [][] arr = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(new NonOverlappingIntervals().eraseOverlapIntervals(arr));
        System.out.println(sb);
    }
}
