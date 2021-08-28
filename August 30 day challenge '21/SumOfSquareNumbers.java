import java.io.*;
import java.util.*;

public class SumOfSquareNumbers {
    public boolean isSquare(long num){
        long root = (long)Math.sqrt(num);
        return root*root == num;
    }
    public boolean judgeSquareSum(int c) {
        for(long a = 0; a*a <= Integer.MAX_VALUE; a++){
            if(isSquare(c - a*a)) {
                return true;
            }
        }
        return false;
    }
    //approach 2 faster but same time complexity
    public boolean judgeSquareSum2(int c) {
        for(int i = 2; i*i <= c; i++){
            int cnt = 0;
            if(c % i == 0){
                while(c % i == 0){
                    cnt++;
                    c /= i;
                }
            }
            if(i % 4 == 3 && cnt % 2 == 1)
                return false;
        }
        return c%4 != 3;
    }
}
