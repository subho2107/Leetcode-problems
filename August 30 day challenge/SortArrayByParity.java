import java.io.*;
import java.util.*;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int [] ans = new int[A.length];
        int pos = 0;
        for (int k : A) {
            if (k % 2 == 0) {
                ans[pos] = k;
                pos++;
            }
        }
        for (int j : A) {
            if (j % 2 == 1) {
                ans[pos] = j;
                pos++;
            }
        }
        return ans;
    }
}
