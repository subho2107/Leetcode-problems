import java.io.*;
import java.util.*;

public class TheKWeakestRowsInAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length, m = mat[0].length;
        int [][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            int cnt = 0;
            for(int j = 0; j < m && mat[i][j] == 1;j++){
                cnt++;
            }
            arr[i][0] = cnt;
            arr[i][1] = i;
        }
        Arrays.sort(arr, new Comparator<int[]>(){
            @Override
            public int compare(int [] a, int [] b){
                if(a[0] != b[0])
                    return a[0]-b[0];
                else
                    return a[1] - b[1];
            }
        });
        int [] kWeakest = new int[k];
        for(int i = 0; i < k; i++){
            kWeakest[i] = arr[i][1];
        }
        return kWeakest;
    }
}
