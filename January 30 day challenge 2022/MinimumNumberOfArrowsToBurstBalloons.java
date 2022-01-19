import java.io.*;
import java.util.*;

public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {//Time complexity:O(n) Space complexity: O(1)
        Arrays.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[0] != o2[0])
                    return o1[0] < o2[0]?-1:1;
                else
                    return o1[1] < o2[1]?-1:1 ;
            }
        });
        int cnt = 0, n = points.length;
        int i = 0, end = points[0][1];
        while(i < n){
            while(i < n && end >= points[i][0]){
                end = Math.min(end, points[i][1]);
                i++;
            }
            cnt++;
            if(i < n)
                end = points[i][1];
        }
        return cnt;
    }
}
