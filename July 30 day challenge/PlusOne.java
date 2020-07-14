import java.io.*;

import java.util.*;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        for (int pos = digits.length-1; pos >= 0; pos--) {
            if (digits[pos]!=9)
            {
                digits[pos]++;
                return digits;
            }
            digits[pos] = 0;
        }
        int [] newArr = new int[digits.length+1];
        newArr[0] = 1;
        return newArr;
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
