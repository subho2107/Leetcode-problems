import java.io.*;
import java.util.*;

public class ReverseBits {
    public int reverseBits(int n) {
        int val = 0, pow = 31;
        while (pow != 0)
        {
            val += (n & 1)<<pow;
            n >>= 1;
            pow--;
        }
        return val;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {

        }
        System.out.println(sb);
    }
}
