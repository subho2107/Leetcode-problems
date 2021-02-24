import java.io.*;
import java.util.*;

public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        for(int i = 0; i < m; i++){
            if(target < matrix[0][i])
                return false;
            int low = 0, high = n-1, mid = 0;
            while(low <= high){
                mid = (low+high)/2;
                int num = matrix[mid][i];
                if(num == target)
                    return true;
                else if(num < target)
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        return false;
    }
}
