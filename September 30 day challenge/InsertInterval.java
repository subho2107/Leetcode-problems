//import java.io.*;
//import java.util.*;
//
//public class InsertInterval {
//    public int[][] insert(int[][] intervals, int[] newInterval) {
//        int [][] ans = new int[intervals.length+1][2];
//        int absX = newInterval[0], absY = newInterval[1], pos = 0;
//        for (int ansPos = 0; pos < intervals.length-1; pos++, ansPos++) {
//            int presX = intervals[pos][0], pres2X = intervals[pos+1][0];
//            if (absX >= presX && absX <pres2X && absY >= presX && absY < pres2X){
//                ans[pos][0] = absX; ans[pos][1] = absY;
//                pos--;
//            }
//            else {
//                ans[ansPos][0] = intervals[pos][0]; ans[ansPos][1] = intervals[pos][1];
//            }
//        }
//
//    }
//    public static void main(String[] args) throws Exception {
//        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        int t = Integer.parseInt(buffer.readLine());
//        while (t-- > 0) {
//
//        }
//        System.out.println(sb);
//    }
//}
