import java.io.*;
import java.util.*;

public class PascalsTriangleII {
    public int binomial(int a, int b){
        long res = 1;
        long n = a, k = b;
        if (k > n - k)
            k = n - k;
        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }
        return (int)res;
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer>kthRow = new ArrayList<Integer>();
        for(int col = 0; col <= rowIndex; col++){
            kthRow.add(binomial(rowIndex, col));
        }
        return kthRow;
    }
}
