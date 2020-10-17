import java.io.*;
import java.util.*;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if( matrix.length == 0||matrix[0].length == 0)
            return false;
        for (int[] ints : matrix) {
            if (target >= ints[0] && target <= ints[matrix[0].length - 1]) {
                int pos = Arrays.binarySearch(ints, target);
                if (pos >= 0 && pos < matrix[0].length && ints[pos] == target)
                    return true;
            }
        }
        return false;
    }
}
