import java.io.*;
import java.util.*;

public class KthSmallestElementInASortedMatrix {
    public int getCntOfSmallerElements(int [][] matrix, int i, int val){
        int low = 0, high = matrix.length - 1;
        if(val >= matrix[i][high])
            return high+1;
        while(low < high){
            int mid = (low + high)>>1;
            if(matrix[i][mid] <= val)
                low = mid+1;
            else
                high = mid;
        }
        return low;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0], high = matrix[n-1][n-1];
        while(low < high){
            int mid = (low + high)/2;
            int cnt = 0;
            for(int i = 0; i < n; i++){
                cnt += getCntOfSmallerElements(matrix, i, mid);
            }
            if(cnt >= k)
                high = mid;
            else
                low = mid+1;
        }
        return high;
    }
}
