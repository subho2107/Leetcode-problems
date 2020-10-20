import java.io.*;
import java.util.*;

public class BestTimeToBuyAndSellStockIV {

    public int getCost(int[] arr, int num) {
        int cnt = 0;
        for (int pos = 0; pos < arr.length; pos++) {
            if (arr[pos] != num)
                cnt++;
        }
        return cnt;
    }

    public int minDominoRotations(int[] A, int[] B) {
        int a = 0, b = 0;
        int n = A.length;
        for (int num = 1; num <= 6; num++) {
            boolean check = true;
            for (int pos = 0; pos < n; pos++) {
                if (A[pos] != num && B[pos] != num) {
                    check = false;
                    break;
                }
            }
            if (check && a == 0)
                a = num;
            else if (check && b == 0)
                b = num;
        }
        if (a == 0)
            return -1;
        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, Math.min(getCost(A, a), getCost(B, a)));
        if (b != 0)
            ans = Math.min(ans, Math.min(getCost(A, b), getCost(B, b)));
        return ans;

    }
}
