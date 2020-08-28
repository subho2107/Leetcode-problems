import java.io.*;
import java.util.*;

public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        if (n == 0)
            return new int[]{};
        if (n == 1)
            return new int[]{-1};
        TreeMap<Integer, Integer> index = new TreeMap<>();
        for (int pos = 0; pos < n; pos++) {
            index.put(intervals[pos][0], pos);
        }
        int [] ans = new int[n];
        for (int pos = 0; pos < n; pos++) {
            Integer key = index.ceilingKey(intervals[pos][1]);
            ans[pos] = key==null?-1:index.get(key);
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        System.out.println(Arrays.toString(new FindRightInterval().findRightInterval(new int[][]{{1,2}, {2,3}, {3,4}})));
        System.out.println(sb);
    }
}
