import java.io.*;
import java.util.*;

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length, cnt = 0, diff = -1, pos = -1;
        for(int i = 0; i < n - 1; i++){
            int currDiff = A[i+1] - A[i];
            if(diff == -1){
                diff = currDiff;
                pos = i;
            }
            else if(diff != currDiff || i == n-2){
                if(i == n-2)
                    i = n-1;
                cnt += (i-pos+1)-2;
                if ((i-pos+1)>3)
                    cnt++;
                diff = -1;
                pos = -1;
            }
        }
        return cnt;
    }

}
