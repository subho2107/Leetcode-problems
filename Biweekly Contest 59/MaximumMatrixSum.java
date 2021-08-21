import java.io.*;
import java.util.*;

public class MaximumMatrixSum {
    public long maxMatrixSum(int[][] matrix) {
        long min = Long.MAX_VALUE, negCnt = 0, absSum = 0, n = matrix.length, m = matrix[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                absSum += Math.abs(matrix[i][j]);
                negCnt += matrix[i][j] < 0?1:0;
                min = Math.min(min, Math.abs(matrix[i][j]));
            }
        }
        if(negCnt % 2 == 0)
            return absSum;
        return absSum - 2*min;
    }
}
