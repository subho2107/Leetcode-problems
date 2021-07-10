import java.io.*;
import java.util.*;

public class MaxSumOfRectangleNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int ans = Integer.MIN_VALUE;
        int n = matrix.length, m = matrix[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 1; j < m; j++)
                matrix[i][j] += matrix[i][j-1];
        }
        for(int i = 0; i < m; i++){
            for(int j = 1; j < n; j++)

                matrix[j][i] += matrix[j-1][i];
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int row = 0; row <= i; row++){
                    for(int col = 0; col <= j; col++){
                        int temp = matrix[i][j];
                        if(col - 1 >= 0)
                            temp -= matrix[i][col-1];
                        if(row - 1 >= 0)
                            temp -= matrix[row-1][j];
                        if(row - 1 >= 0 && col - 1 >= 0)
                            temp += matrix[row-1][col-1];
                        if(temp <= k)
                            ans = Math.max(ans, temp);
                    }
                }
            }
        }
        return ans;
    }
}
