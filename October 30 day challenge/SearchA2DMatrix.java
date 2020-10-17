import java.io.*;
import java.util.*;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int n = matrix.length, m = matrix[0].length;
        int startRow = 0, endRow = n - 1;
        while (startRow <= endRow) {
            int mid = (startRow + endRow) / 2;
            if (target >= matrix[mid][0] && target <= matrix[mid][m - 1]) {
                int index = Arrays.binarySearch(matrix[mid], target);
                if (index >= 0 && index < m && matrix[mid][index] == target)
                    return true;
                else
                    return false;
            } else if (target < matrix[mid][0])
                endRow = mid - 1;
            else
                startRow = mid + 1;
        }
        return false;
    }
}
