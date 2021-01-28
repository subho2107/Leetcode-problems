import java.io.*;
import java.util.*;

public class ConcatenationOfConsecutiveBinaryNumbers {
    public int concatenatedBinary(int n) {
        int MOD = (int)1e9+7;
        long val = 0;
        for(int i = 1; i <= n; i++){
            int currLen = (int)(Math.log(i)/Math.log(2))+1;
            val = ((val<<currLen) + i)%MOD;
            val %= MOD;
        }
        return (int)val;
    }
}
