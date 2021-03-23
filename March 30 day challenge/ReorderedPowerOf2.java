import java.io.*;
import java.util.*;

public class ReorderedPowerOf2 {
    public boolean reorderedPowerOf2(int N) {
        int[] freq = new int[10];
        while (N != 0) {
            freq[N % 10]++;
            N /= 10;
        }
        long curr = 1;
        int lenOfN = Integer.toString(N).length();
        while (Long.toString(curr).length() <= lenOfN) {
            int[] currFreq = new int[10];
            long dup = curr;
            while (dup != 0) {
                currFreq[(int) dup % 10]++;
                dup /= 10;
            }
            boolean check = true;
            for (int i = 0; i < 10; i++) {
                if (currFreq[i] != freq[i]) {
                    check = false;
                    break;
                }
            }
            if (check)
                return true;
            curr *= 2;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new ReorderedPowerOf2().reorderedPowerOf2(16));
    }
}
